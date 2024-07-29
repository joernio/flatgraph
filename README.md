# flatgraph
Successor of [overflowdb](https://github.com/ShiftLeftSecurity/overflowdb), and formerlly known as overflowdbv2...

Code formatting is maintained via
```
sbt scalafmt Test/scalafmt
```

## Core Features
- [x] Access nodes and neighbors
- [x] Add nodes and edges
- [x] Delete edges
- [x] Delete nodes
- [x] Support multiple node types and edge types
- [x] Full support for self-edges; neighbor order is well-defined
- [x] Support node properties
- [x] Support a single optional edge property
- [x] Support file IO
- [ ] Version counters for stuff like iterator invalidation

## Performance and memory features
- [ ] Support compressed memory representation if actual quantity is 0-1
- [ ] Multi-thread batched update application

## Edge Properties and edge identity
### Edge Property storage
Each edge has exactly one property. The property default and type (String vs Int vs ...) is determined by the schema, and can
depend on edge kind (AST vs CFG), node kind (CALL vs METHOD) and direction (but the types need to be consistent).
The singleton `object DefaultValue` is used as formal default argument to `addEdge`; using it in `setEdgeProperty` will 
reset the edge's property to its default value.

Primitives are stored unboxed; null values for non-primitives are supported. `NaN` values in Float or Double valued edge properties will
probably blow up some sanity checks / assertions (lol scala, `==` is not reflexive).

It is impossible to determine whether a property has been set to its default value or is missing (has been set to `DefaultValue`).
Until edge properties of an edgeKind are actually set, we store them as `DefaultValue(default)` instead of `Array[PropertyType]`, i.e.
the edge property feature incurs negligible O(1) memory cost unless actually used in a graph.

### Edge identity
The graph is stored in adjacency lists, and the ordering of the adjacency lists is preserved and well-defined. Batched 
updates to the graph are applied "as if they were unbatched" for the sake of ordering. When a full directed edge A->B is added,
then we add both half-edges A->B and B<-A (meaning: `B` is appended to the list of out-neighbors of `A`, and `A` is appended
to the list of in-neighbors of `B`). The order of edge additions will then determine the order of out-neighbors and in-neighbors.

In order to permit `setEdgeProperty` and to give meaningful semantics to `removeEdge` we therefore need a concept of edge-identity,
i.e. a pairing of all half-edges `A->B` with all half-edges `B<-A` of the same edgeKind. Then we need to defend the invariant
that paired half-edges `A->B` and `B<-A` have the same property value.

Since edges are not explicitly stored in the graph, the JVM will not help us with this pairing.

We are using the obvious pairing between the first `A->B` half-edge (in the order of out-neighbors of A) against the first
`B<-A` edge (in the order of in-neighbors of `B`), and second-against-second and so on.

Note that this is only an issue for multi-graphs, i.e. graphs with multiple `A->B` edges; and the issue is only critical
in view of edge properties.

In the implmentation, edges store their offset into the neighbor list. This allows fast edge construction. We count preceding
similar (same source, same destination, same edgeKind) half-edges only when the pairing is actually required, i.e. when the edge is used
in `setEdgeProperty` or in `removeEdge`. This has the effect that e.g. removing all edges from a graph has worst-case O(E^2)
complexity, where E is the number of edges. Node deletion implicitly removes all incident edges, but can use a fast
algorithm and does not suffer from bad complexity classes.

### Hidden invariant
The way we process edge additions establishes a hidden invariant. Consider the following graph with 4 nodes and 4 edges:
```
   V0    -> V1, V2
   V1    <- V3, V0
   V2    <- V0, V3
   V3    -> V2, V1
```
It is impossible to construct this graph, with this ordering of in-neighbors and out-neighbors, by using only `addEdge`.
In order to see this, consider either the unit tests where all possible 4! = 24 orders of edge additions are tested, or consider
the following argument:

The ordering of out-neighbors of `V0` implies that the edge `V0->V1` was added before `V0->V2` (because in/out neighbors 
are appended to the end of adjacency lists). 
The second line, i.e. the ordering of in-neighbors of V1, implies that `V3->V1` was added before `V0->V1`.
The fourth line imples that `V3->V2` was added before `V3->V1`.
The third line implies that `V0->V2` was added before `V3->V2`.

This is a contradiction.

Note that this hidden invariant also holds for overflowdbv1.

### UnsafeAddHalfEdge
When a graph with certain ordering of adjacency lists is desired, then it is quite cumbersome to determine
whether this is possible by edge additions at all (see above example), and if so to determine the required order of edge additions.

For this reason, we also support unsafe additions of half-edges. These are unsafe in the sense that we cannot check validity i.e.
that the reverse half-edge has been added at all and that the paired half-edge has the same property value.


Bad half-edges are liable to lead to exceptions or wrong results later on, but not "nasal demon"-style UB.

## Open Design decisions
There are several ways of updating a graph:

- [x] Node deletion via tombstones (stable sequential ids). Disadvantage: Deleted nodes leave something behind and bloat the graph.
- [ ] Node deletion via seqId reindexing. Disadvantage: Forbids certain other features.
- [x] Full copy-on-write: Contents are never overwritten. Disadvantage: More allocations/copies than necessary.
- [ ] In-place updates with over-allocated arrays. Disadvantage: Forbids certain other features.
- [ ] Snapshots with almost O(1) time to restore state. Might be cool for the repl! Requires tombstone-deletion and full copy-on-write.
- [ ] Transient external properties. See extra point for discussion.
- [ ] Persistent external properties. Requires tombstone deletion. See extra point for discussion.
- [ ] Lazy-loading of graph components. Requires tombstone deletion.
- [ ] Overflow to disk. Requires tombstone deletion.

### External properties
An external property is functionally similar to a `HashMap[Node, T]` without iteration. However, we can use the structured 
kindId/sequenceId pair with virtually the same indexing scheme to get very fast access and reduced memory consumption, 
if the external property is "dense", i.e. is defined for most nodes of a kind. A transient external property goes out-of-sync, 
i.e. becomes invalid, if the graph is modified; a persistent external property stays valid. If we re-index seqIds of nodes, 
e.g. because of node deletions without tombstones, then external properties become invalid unless we do heroics (heroics 
would mean: The external proeperty registers itself via WeakRef in the graph, and updates fix the registered external properties).

Via implicits, an external property can be made to look like a "real" property of an object (i.e. it can be used as 
`val lhs = node.foo` / `node.foo = rhs`), and can be used well in multithreaded contexts (i.e. only the same property 
on the same node races against itself) with only O(1) total synchronization events, as opposed to hashmaps that require 
synchronization of some kind on every access (typically via atomics).

# Benchmarks
Prerequisite: a test graph in the codepropertygraph schema in `./cpg.fg` - easiest option is to create one with joern, e.g. using `./c2cpg.sh -J-Xmx5g -o cpg.fg /path/to/linux-4.1.16/drivers/net/ethernet`
To start the benchmark, execute the `./runBenchmarks.sh` script. 
It compiles and stages this build and converts the given `cpg.bin` from overflowdbv1 into a `./cpg.fg` in the flatgraph format using the `odbConvert` tool. 

The memory benchmarks rely on `jcmd`, so make sure to have the full sdk installed. 

## JMH benchmarks
The jmh `perfnorm` profiler relies on linux `perf`, so make sure to have that installed. For the `perfasm` profiler in jmh 
(the one that shows the actual instructions that eat our time), it is good to have:
1. debug symbols for the jdk (under archlinux, you get them by installing the `sources` package of the jdk)
2. hsdis (hotspot disassembler). This is super annoying because of GPL issues with binutils. You need to ensure presence of 
`/usr/lib/jvm/java-19-openjdk/lib/hsdis-amd64.so` (or analogue on your distro). You can either google for instructions and build it 
from the openjdk tree or download a binary somewhere.

As of now, all profilers are disabled by default. Enable them by uncommenting the relevant lines in 
`benchmarks/src/main/scala/flatgraph/benchmark/JmhBenchmarks.scala`. Main reason for that the output somewhat too verbose 
for one-glance comparisons. But when trying to understand what goes right or wrong, the output of especially perfnorm
is super important!

We benchmark three operations:
1. `astDFS` descend the AST in depth-first-order, starting from all AST roots, normalized by number of `_astOut` calls. Roughly
```scala
  def astDFS(): Unit = {
    val stack = scala.collection.mutable.ArrayDeque[StoredNode]()
    stack.addAll(nodeStart)
    while (stack.nonEmpty) {
      val nx = stack.removeLast()
      stack.appendAll(nx._astOut)
    }
  }
  ```
2. `astUp` ascend the AST to a root, starting from each node, normalized by number of `_astIn` calls. Roughly
```scala
  def astUp(): Unit = {
    for (node <- nodeStart) {
      var p = node
      while (p != null) {
        p = p._astIn.nextOption.orNull
      }
    }
  }
  ```
3. look at the `order` field of all ast-nodes, normalized by number of `order` calls. Roughly
```scala
  def orderSum(): Int = {
    var sumOrder = 0
    for (node <- nodeStart) {
      sumOrder += node.order
    }
    sumOrder
  }
  ```
We benchmark with either the default iterator order, or with the nodes shuffled into random order (the `shuffle` parameter).
For the `orderSum` benchmark in flatgraph, previous benchmarks (cf git history and PR discussion on 
https://github.com/ShiftLeftSecurity/overflowdbv2/pull/17) have demonstrated that it is very worthwile to avoid 
dynamic dispatch on property access. The three variants benchmarked here show three possible styles of access, and demonstrate
that we achieved the goal of getting roughly the same performance as the devirtualized variant.

Historic results are collected in [benchmarks/results-history](benchmarks/results-history).
Basic results as of 20/11/2023 without profiler output:
Note: we use the JMH mode `AverageTime`, i.e. a lower `Score` is better
```
Benchmark                                   (shuffled)  Mode  Cnt       Score        Error  Units
FlatgraphGenerated.astDFS                         true  avgt    6      29.924 ±      3.052  ns/op
FlatgraphGenerated.astDFS                        false  avgt    6      28.688 ±      3.184  ns/op
FlatgraphGenerated.astUp                          true  avgt    6      55.603 ±     17.387  ns/op
FlatgraphGenerated.astUp                         false  avgt    6      14.767 ±      0.933  ns/op
FlatgraphGenerated.callOrderExplicit              true  avgt    6      58.582 ±      4.613  ns/op
FlatgraphGenerated.callOrderExplicit             false  avgt    6       9.241 ±      0.599  ns/op
FlatgraphGenerated.callOrderTrav                  true  avgt    6      73.348 ±      5.724  ns/op
FlatgraphGenerated.callOrderTrav                 false  avgt    6      12.503 ±      3.952  ns/op
FlatgraphGenerated.indexedMethodFullName          true  avgt    6      31.760 ±      4.916  ns/op
FlatgraphGenerated.indexedMethodFullName         false  avgt    6      20.909 ±      1.494  ns/op
FlatgraphGenerated.orderSumChecked                true  avgt    6      89.349 ±      5.365  ns/op
FlatgraphGenerated.orderSumChecked               false  avgt    6       9.703 ±      1.460  ns/op
FlatgraphGenerated.orderSumExplicit               true  avgt    6      74.298 ±      3.823  ns/op
FlatgraphGenerated.orderSumExplicit              false  avgt    6       7.715 ±      0.585  ns/op
FlatgraphGenerated.orderSumUnchecked              true  avgt    6      83.628 ±      8.407  ns/op
FlatgraphGenerated.orderSumUnchecked             false  avgt    6       8.366 ±      0.659  ns/op
FlatgraphGenerated.unindexedMethodFullName        true  avgt    6  467235.950 ± 175279.253  ns/op
FlatgraphGenerated.unindexedMethodFullName       false  avgt    6  488670.733 ±  42903.262  ns/op
```

Feel free to add more benchmarks or prettify the output!

## Odbv2 loading and memory
We can convert odbv1 files to the current serialization format via 
```
./odb-convert/target/universal/stage/bin/odb-convert ./cpg.bin ./cpg.fg > out.json
```
(or pipe to `/dev/null` if we don't care to look at the storage manifest json for debugging)
That allows us to benchmark loading time and memory consumption:

<details>
  <summary>click to see details of flatgraph benchmarks without generated schema</summary>

```
VM is version 19.0.2+7 with max heap 20480 mb.


Graph with 2387850 nodes and 20220777 edges at ./cpg.fg.
On disk 87386915 bytes = 36.59648428502628 bytes/node.
Loading data from disk at 19.573005832738232 ns/byte and filling the heap at 2.766862397474049 ns/byte.

<=========
Running complete benchmark in 1710424597 ns  == 1710.424597 ms == 0.7163032003685323 us/node and costing 618182024 bytes == 589.544319152832 MB == 258.886456016919 bytes/node.
Top 20 account for 99.98543082838009%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
int[], 535, 244993040, 2.2405092447180518E-4,  457930.91588785045, 102.59984504889336
io.joern.odb2.GNode[], 214, 171321536, 8.962036978872208E-5,  800567.9252336449, 71.74719350042926
String[], 405, 69458880, 1.696086437590301E-4,  171503.40740740742, 29.088460330422766
io.joern.odb2.GNode, 2387850, 57308400, 1.0,  24.0, 24.0
byte[], 626834, 40533616, 0.26250978914085893,  64.66403545436272, 16.974942312121783
long[], 26, 19103216, 1.0888456142555019E-5,  734739.0769230769, 8.000174215298282
String, 626819, 15043656, 0.2625035073392382,  24.0, 6.300084176141717
Object[], 509, 123360, 2.1316246832925017E-4,  242.35756385068763, 0.05166153652867642
Class, 552, 66504, 2.3117029964193732E-4,  120.47826086956522, 0.02785099566555688
java.util.concurrent.ConcurrentHashMap$Node, 1701, 54432, 7.123563037879264E-4,  32.0, 0.022795401721213644
java.util.concurrent.ConcurrentHashMap$Node[], 15, 12912, 6.281801620704818E-6,  860.8, 0.005407374835102708
java.lang.invoke.MemberName, 262, 12576, 1.0972213497497749E-4,  48.0, 0.00526666247879892
java.lang.invoke.MethodType, 229, 9160, 9.590217140942689E-5,  40.0, 0.0038360868563770754
java.lang.ref.SoftReference[], 116, 8816, 4.857926586678393E-5,  76.0, 0.0036920242058755787
Object, 547, 8752, 2.2907636576836903E-4,  16.0, 0.0036652218522939045
sun.security.util.KnownOIDs, 263, 8416, 1.1014092174969114E-4,  32.0, 0.0035245094959901165
Class[], 257, 8032, 1.0762820110140921E-4,  31.252918287937742, 0.003363695374500073
java.lang.invoke.LambdaForm$Name, 207, 6624, 8.668886236572648E-5,  32.0, 0.0027740435957032475
java.lang.reflect.Method, 60, 5280, 2.512720648281927E-5,  88.0, 0.002211194170488096
java.lang.invoke.ResolvedMethodName, 198, 4752, 8.29197813933036E-5,  24.0, 0.0019900747534392863
=========>



<=========
Running load flat cpg file in 1170588311 ns  == 1170.588311 ms == 0.4902269032811944 us/node and costing 618175232 bytes == 589.537841796875 MB == 258.8836116171451 bytes/node.
Top 20 account for 99.98182780639131%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
int[], 537, 244993072, 2.2488849802123248E-4,  456225.459962756, 102.59985845007014
io.joern.odb2.GNode[], 214, 171321536, 8.962036978872208E-5,  800567.9252336449, 71.74719350042926
String[], 405, 69458880, 1.696086437590301E-4,  171503.40740740742, 29.088460330422766
io.joern.odb2.GNode, 2387850, 57308400, 1.0,  24.0, 24.0
byte[], 626379, 40510560, 0.2623192411583642,  64.67419884766252, 16.965286764243984
long[], 26, 19103216, 1.0888456142555019E-5,  734739.0769230769, 8.000174215298282
String, 626364, 15032736, 0.26231295935674354,  24.0, 6.295511024561844
Object[], 474, 122128, 1.9850493121427226E-4,  257.65400843881855, 0.051145591222229204
Class, 507, 61344, 2.1232489477982286E-4,  120.99408284023669, 0.025690055908034425
java.util.concurrent.ConcurrentHashMap$Node, 1681, 53792, 7.039805682936533E-4,  32.0, 0.022527378185396907
jdk.internal.ref.Cleaner, 409, 16360, 1.712837908578847E-4,  40.0, 0.006851351634315389
java.util.concurrent.ConcurrentHashMap$Node[], 15, 12656, 6.281801620704818E-6,  843.7333333333333, 0.005300165420776012
java.lang.invoke.MemberName, 222, 10656, 9.297066398643131E-5,  48.0, 0.0044625918713487025
sun.nio.ch.FileChannelImpl$DefaultUnmapper, 201, 9648, 8.417614171744456E-5,  48.0, 0.004040454802437339
java.lang.ref.SoftReference[], 114, 8664, 4.774169231735662E-5,  76.0, 0.003628368616119103
sun.security.util.KnownOIDs, 263, 8416, 1.1014092174969114E-4,  32.0, 0.0035245094959901165
java.io.FileDescriptor, 203, 8120, 8.501371526687188E-5,  40.0, 0.003400548610674875
Object, 497, 7952, 2.0813702703268631E-4,  16.0, 0.003330192432522981
java.lang.invoke.MethodType, 190, 7600, 7.956948719559436E-5,  40.0, 0.0031827794878237746
Class[], 227, 7160, 9.506459785999958E-5,  31.54185022026432, 0.0029985133069497663
=========>



<=========
Running count edges (force complete loading) in 277801887 ns  == 277.80188699999997 ms == 0.1163397562660971 us/node and costing 64728 bytes == 0.06172943115234375 MB == 0.02710723035366543 bytes/node.
Top 20 account for 99.81460882461995%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
byte[], 760, 40248, 3.182779487823774E-4,  52.95789473684211, 0.016855330108675168
String, 760, 18240, 3.182779487823774E-4,  24.0, 0.007638670770777059
Class, 16, 1832, 6.700588395418473E-6,  114.5, 7.672173712754151E-4
java.util.concurrent.ConcurrentHashMap$Node, 42, 1344, 1.7589044537973492E-5,  32.0, 5.628494252151517E-4
java.lang.invoke.MemberName, 11, 528, 4.6066545218502E-6,  48.0, 2.211194170488096E-4
java.lang.invoke.MethodType, 11, 440, 4.6066545218502E-6,  40.0, 1.84266180874008E-4
java.lang.invoke.MethodType$ConcurrentWeakInternSet$WeakEntry, 13, 416, 5.444228071277509E-6,  32.0, 1.742152982808803E-4
Object, 24, 384, 1.005088259312771E-5,  16.0, 1.6081412149004335E-4
Class[], 8, 216, 3.3502941977092363E-6,  27.0, 9.045794333814938E-5
Object[], 6, 208, 2.5127206482819273E-6,  34.666666666666664, 8.710764914044015E-5
java.lang.invoke.ResolvedMethodName, 8, 192, 3.3502941977092363E-6,  24.0, 8.040706074502167E-5
java.lang.invoke.DirectMethodHandle$Constructor, 3, 144, 1.2563603241409637E-6,  48.0, 6.0305295558766256E-5
java.lang.invoke.DirectMethodHandle, 3, 120, 1.2563603241409637E-6,  40.0, 5.025441296563854E-5
int[], 7, 112, 2.9315074229955816E-6,  16.0, 4.6904118767929306E-5
java.lang.invoke.LambdaForm$Name, 2, 64, 8.375735494273091E-7,  32.0, 2.680235358167389E-5
java.lang.invoke.LambdaForm, 1, 48, 4.1878677471365454E-7,  48.0, 2.010176518625542E-5
jdk.internal.ref.CleanerImpl$PhantomCleanableRef, -1, -48, -4.1878677471365454E-7,  48.0, -2.010176518625542E-5
java.lang.invoke.LambdaForm$Name[], 1, 40, 4.1878677471365454E-7,  40.0, 1.675147098854618E-5
java.lang.ref.SoftReference, 1, 40, 4.1878677471365454E-7,  40.0, 1.675147098854618E-5
java.lang.Package$VersionInfo, 1, 40, 4.1878677471365454E-7,  40.0, 1.675147098854618E-5
=========>



<=========
Running count edges again in 262034399 ns  == 262.034399 ms == 0.10973654082124086 us/node and costing 53016 bytes == 0.05055999755859375 MB == 0.022202399648219108 bytes/node.
Top 20 account for 100.0%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
byte[], 684, 36664, 2.864501539041397E-4,  53.60233918128655, 0.01535439830810143
String, 684, 16416, 2.864501539041397E-4,  24.0, 0.006874803693699353
jdk.internal.ref.CleanerImpl$PhantomCleanableRef, -1, -48, -4.1878677471365454E-7,  48.0, -2.010176518625542E-5
java.lang.invoke.MethodHandleNatives$CallSiteContext, -1, -32, -4.1878677471365454E-7,  32.0, -1.3401176790836945E-5
Integer, 1, 16, 4.1878677471365454E-7,  16.0, 6.700588395418473E-6
=========>



<=========
Running free memory in 11403 ns  == 0.011403 ms == 4.775425592059803E-6 us/node and costing -617520016 bytes == -588.9129791259766 MB == -258.60921582176434 bytes/node.
Top 20 account for 100.0%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
int[], -438, -244990512, -1.834286073245807E-4,  559339.0684931506, -102.59878635592688
io.joern.odb2.GNode[], -214, -171321536, -8.962036978872208E-5,  800567.9252336449, -71.74719350042926
String[], -117, -69452680, -4.899805264149758E-5,  593612.6495726496, -29.08586385241954
io.joern.odb2.GNode, -2387850, -57308400, -1.0,  24.0, -24.0
byte[], -622100, -40315024, -0.2605272525493645,  64.80473235814178, -16.883398873463577
long[], -25, -19103200, -1.0469669367841363E-5,  764128.0, -8.000167514709885
String, -622101, -14930424, -0.2605276713361392,  24.0, -6.2526641120673405
Object[], -8, -97456, -3.3502941977092363E-6,  12182.0, -0.040813283916493914
io.joern.odb2.DefaultValue, -31, -496, -1.2982390016123291E-5,  16.0, -2.0771824025797266E-4
io.joern.odb2.GNode[][], -1, -112, -4.1878677471365454E-7,  112.0, -4.6904118767929306E-5
jdk.internal.ref.CleanerImpl$PhantomCleanableRef, -1, -48, -4.1878677471365454E-7,  48.0, -2.010176518625542E-5
boolean[], -2, -32, -8.375735494273091E-7,  16.0, -1.3401176790836945E-5
io.joern.odb2.FreeSchema, -1, -32, -4.1878677471365454E-7,  32.0, -1.3401176790836945E-5
io.joern.odb2.Graph, -1, -32, -4.1878677471365454E-7,  32.0, -1.3401176790836945E-5
java.lang.invoke.MethodHandleNatives$CallSiteContext, -1, -32, -4.1878677471365454E-7,  32.0, -1.3401176790836945E-5
=========>


# WARNING: Unable to attach Serviceability Agent. You can try again with escalated privileges. Two options: a) use -Djol.tryWithSudo=true to try with sudo; b) echo 0 | sudo tee /proc/sys/kernel/yama/ptrace_scope
VM details according to JOL: # Running 64-bit HotSpot VM.
# Using compressed oop with 3-bit shift.
# Using compressed klass with 3-bit shift.
# WARNING | Compressed references base/shifts are guessed by the experiment!
# WARNING | Therefore, computed addresses are just guesses, and ARE NOT RELIABLE.
# WARNING | Make sure to attach Serviceability Agent to get the reliable addresses.
# Objects are 8 bytes aligned.
# Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
# Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
. Layout of top consumers: 


io.joern.odb2.GNode object internals:
OFF  SZ                  TYPE DESCRIPTION               VALUE
  0   8                       (object header: mark)     N/A
  8   4                       (object header: class)    N/A
 12   4                   int GNode._seqId              N/A
 16   2                 short GNode.nodeKind            N/A
 18   1               boolean GNode._isDeleted          N/A
 19   1                       (alignment/padding gap)   
 20   4   io.joern.odb2.Graph GNode.graph               N/A
Instance size: 24 bytes
Space losses: 1 bytes internal + 0 bytes external = 1 bytes total


java.util.concurrent.ConcurrentHashMap$Node object internals:
OFF  SZ                                          TYPE DESCRIPTION               VALUE
  0   8                                               (object header: mark)     N/A
  8   4                                               (object header: class)    N/A
 12   4                                           int Node.hash                 N/A
 16   4                              java.lang.Object Node.key                  N/A
 20   4                              java.lang.Object Node.val                  N/A
 24   4   java.util.concurrent.ConcurrentHashMap.Node Node.next                 N/A
 28   4                                               (object alignment gap)    
Instance size: 32 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


java.lang.invoke.MemberName object internals:
OFF  SZ                                  TYPE DESCRIPTION               VALUE
  0   8                                       (object header: mark)     N/A
  8   4                                       (object header: class)    N/A
 12   4                                   int MemberName.flags          N/A
 16   8                                       (alignment/padding gap)   
 24   4                       java.lang.Class MemberName.clazz          N/A
 28   4                      java.lang.String MemberName.name           N/A
 32   4                      java.lang.Object MemberName.type           N/A
 36   4   java.lang.invoke.ResolvedMethodName MemberName.method         N/A
 40   4                      java.lang.Object MemberName.resolution     N/A
 44   4                                       (object alignment gap)    
Instance size: 48 bytes
Space losses: 8 bytes internal + 4 bytes external = 12 bytes total


java.lang.invoke.MethodType object internals:
OFF  SZ                              TYPE DESCRIPTION                   VALUE
  0   8                                   (object header: mark)         N/A
  8   4                                   (object header: class)        N/A
 12   4                   java.lang.Class MethodType.rtype              N/A
 16   4                 java.lang.Class[] MethodType.ptypes             N/A
 20   4   java.lang.invoke.MethodTypeForm MethodType.form               N/A
 24   4                  java.lang.Object MethodType.wrapAlt            N/A
 28   4         java.lang.invoke.Invokers MethodType.invokers           N/A
 32   4                  java.lang.String MethodType.methodDescriptor   N/A
 36   4                                   (object alignment gap)        
Instance size: 40 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


sun.security.util.KnownOIDs object internals:
OFF  SZ                 TYPE DESCRIPTION               VALUE
  0   8                      (object header: mark)     N/A
  8   4                      (object header: class)    N/A
 12   4                  int Enum.ordinal              N/A
 16   4     java.lang.String Enum.name                 N/A
 20   4     java.lang.String KnownOIDs.stdName         N/A
 24   4     java.lang.String KnownOIDs.oid             N/A
 28   4   java.lang.String[] KnownOIDs.aliases         N/A
Instance size: 32 bytes
Space losses: 0 bytes internal + 0 bytes external = 0 bytes total


java.lang.invoke.LambdaForm$Name object internals:
OFF  SZ                                        TYPE DESCRIPTION               VALUE
  0   8                                             (object header: mark)     N/A
  8   4                                             (object header: class)    N/A
 12   2                                       short Name.index                N/A
 14   2                                             (alignment/padding gap)   
 16   4       java.lang.invoke.LambdaForm.BasicType Name.type                 N/A
 20   4   java.lang.invoke.LambdaForm.NamedFunction Name.function             N/A
 24   4                            java.lang.Object Name.constraint           N/A
 28   4                          java.lang.Object[] Name.arguments            N/A
Instance size: 32 bytes
Space losses: 2 bytes internal + 0 bytes external = 2 bytes total


java.lang.reflect.Method object internals:
OFF  SZ                            TYPE DESCRIPTION                       VALUE
  0   8                                 (object header: mark)             N/A
  8   4                                 (object header: class)            N/A
 12   1                                 (alignment/padding gap)           
 13   1                         boolean Executable.hasRealParameterData   N/A
 14   6                                 (alignment/padding gap)           
 20   4   java.lang.reflect.Parameter[] Executable.parameters             N/A
 24   4                   java.util.Map Executable.declaredAnnotations    N/A
 28   4                                 (object alignment gap)            
Instance size: 32 bytes
Space losses: 7 bytes internal + 4 bytes external = 11 bytes total


java.lang.invoke.ResolvedMethodName object internals:
OFF  SZ   TYPE DESCRIPTION               VALUE
  0   8        (object header: mark)     N/A
  8   4        (object header: class)    N/A
 12   4        (object alignment gap)    
Instance size: 16 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
```
</details>

The resulting memory consumption, load speed and file-size are all quite promising.

The runtime for counting all edges with 110 ns/node is a bit faster than odbv1 170 ns/node.
It is still a disaster and completely unacceptable. We'll see how this fares with a real 
generated schema (as opposed to an ad-hoc schema infered from the graph data).

# FAQ

## What JDK does flatgraph support?
The build targets JDK8, so that's the minimum version. The build itself requires JDK11+. 
However in any case it is highly encouraged to use a modern JVM, such as JDK20. 

## What does EMT stand for?
EMT is a naming convention that stands for "erased marker trait". 
The domain classes generator generates one for each property in the schema and users can define additional marker traits. 

[CompileTests.scala][benchmarks/src/test/scala/flatgraph/benchmark/CompileTests.scala] demonstrates how users can add these marker traits ad-hoc - in this case to add a `IsStaticEMT` marker to a `Call` node, to indicate that the given `Call` is static. Note that the original schema does not have that attribute, so this is to demonstrate the extensibility and type safety of the domain classes.

The marker traits help to improve type safety, e.g. to permit specific implicits/extensions on them (see CompileTests
linked above). They exist only at compile time. Hence, it's safe to cast a given node instance to this marker type, since it's erased at runtime.

(n.b. these marker traits do not define any members or functions, otherwise their usage would result in a ClasscastException at runtime)

## This looks so bad in the debugger / object inspector!

Yes, properties are no longer fields of stored nodes. Hence the debugger cannot find them.

But despair not! We have attached the `_debugChildren()` method to the GNode class. In order to see anything useful, you need to tell your debugger to use that in its object inspector. So in intellij, you need to add a custom java type renderer, make it apply to all `flatgraph.GNode` instances, and then tell it to use the expression `_debugChildren()` when expanding a node. See e.g. https://www.jetbrains.com/help/idea/customizing-views.html#renderers .
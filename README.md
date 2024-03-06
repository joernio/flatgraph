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
The graph is stored in adjecency lists, and the ordering of the adjecency lists is preserved and well-defined. Batched 
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
Prerequisite: a test graph in the old overflowdb format in `./cpg.bin`. 
To start the benchmark, execute the `./runBenchmarks.sh` script. 
It compiles and stages this build and converts the given `cpg.bin` from overflowdbv1 into a `./cpg.fg` in the flatgraph format using the `odbConvert` tool. 

Then outputs of the script are placed in `./benchmarks/target/jmh-output.txt` and `./benchmarks/target/jmh-results.csv` and  for iteration over the graph. And for graph loading and memory consumption in `./odb1Results.txt` and `./fgResults.txt`. 

For this you need an example graph that you can conveniently generate with joern and take from the workspace 
(don't forget to save). Since this uses joern domain classes, it is incompatible with ocular/codescience graphs. It is also
incompatible with the legacy proto format (just load in joern and save). 

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
The three kinds of graph we test are `JoernLegacy`, which uses the generic Tinkerpop-like graph API, `JoernGenerated` which uses
the API belonging to the generated domain classes, and `FlatgraphGenerated` which runs on the generated domain classes for flatgraph.
For the `orderSum` benchmark in flatgraph, previous benchmarks (cf git history and PR discussion on 
https://github.com/ShiftLeftSecurity/overflowdbv2/pull/17) have demonstrated that it is very worthwile to avoid 
dynamic dispatch on property access. The three variants benchmarked here show three possible styles of access, and demonstrate
that we achieved the goal of getting roughly the same performance as the devirtualized variant.

Historic results are collected in [benchmarks/results-history](benchmarks/results-history).
Basic results as of 20/11/2023 without profiler output:
Note: we use the JMH mode `AverageTime`, i.e. a lower `Score` is better
```
Benchmark                                   (shuffled)  Mode  Cnt     Score     Error  Units
FlatgraphGenerated.astDFS                         true  avgt    6    23.788 ±   2.304  ns/op
FlatgraphGenerated.astDFS                        false  avgt    6    23.226 ±   2.537  ns/op
FlatgraphGenerated.astUp                          true  avgt    6    15.283 ±   0.775  ns/op
FlatgraphGenerated.astUp                         false  avgt    6    13.270 ±   2.469  ns/op
FlatgraphGenerated.callOrderExplicit              true  avgt    6     6.598 ±   1.373  ns/op
FlatgraphGenerated.callOrderExplicit             false  avgt    6     6.204 ±   1.571  ns/op
FlatgraphGenerated.callOrderTrav                  true  avgt    6     9.224 ±   0.447  ns/op
FlatgraphGenerated.callOrderTrav                 false  avgt    6     9.014 ±   0.521  ns/op
FlatgraphGenerated.indexedMethodFullName          true  avgt    6    16.214 ±   1.588  ns/op
FlatgraphGenerated.indexedMethodFullName         false  avgt    6    18.485 ±   0.930  ns/op
FlatgraphGenerated.orderSumChecked                true  avgt    6     9.956 ±   0.257  ns/op
FlatgraphGenerated.orderSumChecked               false  avgt    6     6.747 ±   0.210  ns/op
FlatgraphGenerated.orderSumExplicit               true  avgt    6     8.655 ±   0.389  ns/op
FlatgraphGenerated.orderSumExplicit              false  avgt    6     6.033 ±   0.140  ns/op
FlatgraphGenerated.orderSumUnchecked              true  avgt    6     8.957 ±   1.097  ns/op
FlatgraphGenerated.orderSumUnchecked             false  avgt    6     5.772 ±   0.418  ns/op
FlatgraphGenerated.unindexedMethodFullName        true  avgt    6  3509.614 ± 130.809  ns/op
FlatgraphGenerated.unindexedMethodFullName       false  avgt    6  3499.558 ± 118.846  ns/op
JoernGenerated.astDFS                             true  avgt    6    33.611 ±   2.489  ns/op
JoernGenerated.astDFS                            false  avgt    6    33.424 ±   2.446  ns/op
JoernGenerated.astUp                              true  avgt    6    26.639 ±   2.119  ns/op
JoernGenerated.astUp                             false  avgt    6    17.488 ±   0.773  ns/op
JoernGenerated.callOrderExplicit                  true  avgt    6     2.931 ±   0.638  ns/op
JoernGenerated.callOrderExplicit                 false  avgt    6     3.097 ±   0.254  ns/op
JoernGenerated.callOrderTrav                      true  avgt    6     5.652 ±   0.453  ns/op
JoernGenerated.callOrderTrav                     false  avgt    6     5.900 ±   0.426  ns/op
JoernGenerated.indexedMethodFullName              true  avgt    6    95.705 ±  15.767  ns/op
JoernGenerated.indexedMethodFullName             false  avgt    6    25.565 ±   1.220  ns/op
JoernGenerated.orderSum                           true  avgt    6    24.494 ±   0.497  ns/op
JoernGenerated.orderSum                          false  avgt    6    15.831 ±   1.353  ns/op
JoernGenerated.unindexedMethodFullName            true  avgt    6  3431.910 ± 362.269  ns/op
JoernGenerated.unindexedMethodFullName           false  avgt    6  3379.487 ± 181.844  ns/op
JoernLegacy.astDFS                                true  avgt    6    40.861 ±   3.241  ns/op
JoernLegacy.astDFS                               false  avgt    6    44.164 ±   5.959  ns/op
JoernLegacy.astUp                                 true  avgt    6    34.245 ±   1.268  ns/op
JoernLegacy.astUp                                false  avgt    6    27.011 ±   1.946  ns/op
JoernLegacy.orderSum                              true  avgt    6    19.391 ±   1.191  ns/op
JoernLegacy.orderSum                             false  avgt    6    10.988 ±   0.340  ns/op
```
Lengthy results with some profiler info are:
<details>
  <summary>see benchmarks with profilers</summary>
```
Benchmark                                                           (shuffled)  Mode  Cnt     Score     Error   Units
joernBench.JoernGenerated.astDFS                                          true  avgt    5    72.939 ±   2.319   ns/op
joernBench.JoernGenerated.astDFS:L1-dcache-load-misses:u                  true  avgt          5.012              #/op
joernBench.JoernGenerated.astDFS:L1-dcache-loads:u                        true  avgt        147.116              #/op
joernBench.JoernGenerated.astDFS:L1-dcache-stores:u                       true  avgt         50.607              #/op
joernBench.JoernGenerated.astDFS:L1-icache-load-misses:u                  true  avgt          0.049              #/op
joernBench.JoernGenerated.astDFS:LLC-load-misses:u                        true  avgt          0.850              #/op
joernBench.JoernGenerated.astDFS:LLC-loads:u                              true  avgt          1.011              #/op
joernBench.JoernGenerated.astDFS:LLC-store-misses:u                       true  avgt          0.023              #/op
joernBench.JoernGenerated.astDFS:LLC-stores:u                             true  avgt          0.110              #/op
joernBench.JoernGenerated.astDFS:branch-misses:u                          true  avgt          0.704              #/op
joernBench.JoernGenerated.astDFS:branches:u                               true  avgt        101.620              #/op
joernBench.JoernGenerated.astDFS:cycles:u                                 true  avgt        368.020              #/op
joernBench.JoernGenerated.astDFS:dTLB-load-misses:u                       true  avgt          0.004              #/op
joernBench.JoernGenerated.astDFS:dTLB-loads:u                             true  avgt        147.691              #/op
joernBench.JoernGenerated.astDFS:dTLB-store-misses:u                      true  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernGenerated.astDFS:dTLB-stores:u                            true  avgt         50.912              #/op
joernBench.JoernGenerated.astDFS:iTLB-load-misses:u                       true  avgt          0.001              #/op
joernBench.JoernGenerated.astDFS:iTLB-loads:u                             true  avgt          0.013              #/op
joernBench.JoernGenerated.astDFS:instructions:u                           true  avgt        533.196              #/op
joernBench.JoernGenerated.astDFS:·gc.alloc.rate                           true  avgt    5   946.179 ±  30.045  MB/sec
joernBench.JoernGenerated.astDFS:·gc.alloc.rate.norm                      true  avgt    5    72.367 ±   0.002    B/op
joernBench.JoernGenerated.astDFS:·gc.count                                true  avgt    5     6.000            counts
joernBench.JoernGenerated.astDFS:·gc.time                                 true  avgt    5    54.000                ms
joernBench.JoernGenerated.astDFS                                         false  avgt    5    67.170 ±   1.355   ns/op
joernBench.JoernGenerated.astDFS:L1-dcache-load-misses:u                 false  avgt          4.737              #/op
joernBench.JoernGenerated.astDFS:L1-dcache-loads:u                       false  avgt        131.308              #/op
joernBench.JoernGenerated.astDFS:L1-dcache-stores:u                      false  avgt         39.523              #/op
joernBench.JoernGenerated.astDFS:L1-icache-load-misses:u                 false  avgt          0.106              #/op
joernBench.JoernGenerated.astDFS:LLC-load-misses:u                       false  avgt          0.822              #/op
joernBench.JoernGenerated.astDFS:LLC-loads:u                             false  avgt          0.979              #/op
joernBench.JoernGenerated.astDFS:LLC-store-misses:u                      false  avgt          0.017              #/op
joernBench.JoernGenerated.astDFS:LLC-stores:u                            false  avgt          0.087              #/op
joernBench.JoernGenerated.astDFS:branch-misses:u                         false  avgt          0.706              #/op
joernBench.JoernGenerated.astDFS:branches:u                              false  avgt         93.393              #/op
joernBench.JoernGenerated.astDFS:cycles:u                                false  avgt        339.123              #/op
joernBench.JoernGenerated.astDFS:dTLB-load-misses:u                      false  avgt          0.005              #/op
joernBench.JoernGenerated.astDFS:dTLB-loads:u                            false  avgt        131.420              #/op
joernBench.JoernGenerated.astDFS:dTLB-store-misses:u                     false  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernGenerated.astDFS:dTLB-stores:u                           false  avgt         39.528              #/op
joernBench.JoernGenerated.astDFS:iTLB-load-misses:u                      false  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernGenerated.astDFS:iTLB-loads:u                            false  avgt          0.015              #/op
joernBench.JoernGenerated.astDFS:instructions:u                          false  avgt        482.898              #/op
joernBench.JoernGenerated.astDFS:·gc.alloc.rate                          false  avgt    5   800.252 ±  16.141  MB/sec
joernBench.JoernGenerated.astDFS:·gc.alloc.rate.norm                     false  avgt    5    56.367 ±   0.002    B/op
joernBench.JoernGenerated.astDFS:·gc.count                               false  avgt    5     7.000            counts
joernBench.JoernGenerated.astDFS:·gc.time                                false  avgt    5    56.000                ms
joernBench.JoernGenerated.astUp                                           true  avgt    5   102.065 ±   3.256   ns/op
joernBench.JoernGenerated.astUp:L1-dcache-load-misses:u                   true  avgt          7.518              #/op
joernBench.JoernGenerated.astUp:L1-dcache-loads:u                         true  avgt        131.250              #/op
joernBench.JoernGenerated.astUp:L1-dcache-stores:u                        true  avgt         60.291              #/op
joernBench.JoernGenerated.astUp:L1-icache-load-misses:u                   true  avgt          0.220              #/op
joernBench.JoernGenerated.astUp:LLC-load-misses:u                         true  avgt          1.350              #/op
joernBench.JoernGenerated.astUp:LLC-loads:u                               true  avgt          2.479              #/op
joernBench.JoernGenerated.astUp:LLC-store-misses:u                        true  avgt          0.026              #/op
joernBench.JoernGenerated.astUp:LLC-stores:u                              true  avgt          0.132              #/op
joernBench.JoernGenerated.astUp:branch-misses:u                           true  avgt          0.963              #/op
joernBench.JoernGenerated.astUp:branches:u                                true  avgt        106.564              #/op
joernBench.JoernGenerated.astUp:cycles:u                                  true  avgt        523.421              #/op
joernBench.JoernGenerated.astUp:dTLB-load-misses:u                        true  avgt          0.003              #/op
joernBench.JoernGenerated.astUp:dTLB-loads:u                              true  avgt        130.964              #/op
joernBench.JoernGenerated.astUp:dTLB-store-misses:u                       true  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernGenerated.astUp:dTLB-stores:u                             true  avgt         60.119              #/op
joernBench.JoernGenerated.astUp:iTLB-load-misses:u                        true  avgt          0.001              #/op
joernBench.JoernGenerated.astUp:iTLB-loads:u                              true  avgt          0.148              #/op
joernBench.JoernGenerated.astUp:instructions:u                            true  avgt        495.330              #/op
joernBench.JoernGenerated.astUp:·gc.alloc.rate                            true  avgt    5   789.419 ±  25.178  MB/sec
joernBench.JoernGenerated.astUp:·gc.alloc.rate.norm                       true  avgt    5    84.485 ±   0.002    B/op
joernBench.JoernGenerated.astUp:·gc.count                                 true  avgt    5     8.000            counts
joernBench.JoernGenerated.astUp:·gc.time                                  true  avgt    5   119.000                ms
joernBench.JoernGenerated.astUp                                          false  avgt    5    36.309 ±   2.229   ns/op
joernBench.JoernGenerated.astUp:L1-dcache-load-misses:u                  false  avgt          2.459              #/op
joernBench.JoernGenerated.astUp:L1-dcache-loads:u                        false  avgt        126.921              #/op
joernBench.JoernGenerated.astUp:L1-dcache-stores:u                       false  avgt         58.756              #/op
joernBench.JoernGenerated.astUp:L1-icache-load-misses:u                  false  avgt          0.035              #/op
joernBench.JoernGenerated.astUp:LLC-load-misses:u                        false  avgt          0.027              #/op
joernBench.JoernGenerated.astUp:LLC-loads:u                              false  avgt          0.085              #/op
joernBench.JoernGenerated.astUp:LLC-store-misses:u                       false  avgt          0.024              #/op
joernBench.JoernGenerated.astUp:LLC-stores:u                             false  avgt          0.127              #/op
joernBench.JoernGenerated.astUp:branch-misses:u                          false  avgt          0.894              #/op
joernBench.JoernGenerated.astUp:branches:u                               false  avgt        104.673              #/op
joernBench.JoernGenerated.astUp:cycles:u                                 false  avgt        195.857              #/op
joernBench.JoernGenerated.astUp:dTLB-load-misses:u                       false  avgt          0.001              #/op
joernBench.JoernGenerated.astUp:dTLB-loads:u                             false  avgt        127.078              #/op
joernBench.JoernGenerated.astUp:dTLB-store-misses:u                      false  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernGenerated.astUp:dTLB-stores:u                            false  avgt         58.924              #/op
joernBench.JoernGenerated.astUp:iTLB-load-misses:u                       false  avgt         ≈ 10⁻³              #/op
joernBench.JoernGenerated.astUp:iTLB-loads:u                             false  avgt          0.069              #/op
joernBench.JoernGenerated.astUp:instructions:u                           false  avgt        479.888              #/op
joernBench.JoernGenerated.astUp:·gc.alloc.rate                           false  avgt    5  2219.341 ± 135.552  MB/sec
joernBench.JoernGenerated.astUp:·gc.alloc.rate.norm                      false  avgt    5    84.485 ±   0.001    B/op
joernBench.JoernGenerated.astUp:·gc.count                                false  avgt    5    16.000            counts
joernBench.JoernGenerated.astUp:·gc.time                                 false  avgt    5   141.000                ms
joernBench.JoernGenerated.orderSum                                        true  avgt    5    83.060 ±   4.335   ns/op
joernBench.JoernGenerated.orderSum:L1-dcache-load-misses:u                true  avgt          4.525              #/op
joernBench.JoernGenerated.orderSum:L1-dcache-loads:u                      true  avgt         52.690              #/op
joernBench.JoernGenerated.orderSum:L1-dcache-stores:u                     true  avgt         13.021              #/op
joernBench.JoernGenerated.orderSum:L1-icache-load-misses:u                true  avgt          0.016              #/op
joernBench.JoernGenerated.orderSum:LLC-load-misses:u                      true  avgt          2.067              #/op
joernBench.JoernGenerated.orderSum:LLC-loads:u                            true  avgt          2.207              #/op
joernBench.JoernGenerated.orderSum:LLC-store-misses:u                     true  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernGenerated.orderSum:LLC-stores:u                           true  avgt          0.001              #/op
joernBench.JoernGenerated.orderSum:branch-misses:u                        true  avgt          0.966              #/op
joernBench.JoernGenerated.orderSum:branches:u                             true  avgt         45.206              #/op
joernBench.JoernGenerated.orderSum:cycles:u                               true  avgt        393.143              #/op
joernBench.JoernGenerated.orderSum:dTLB-load-misses:u                     true  avgt          0.001              #/op
joernBench.JoernGenerated.orderSum:dTLB-loads:u                           true  avgt         52.729              #/op
joernBench.JoernGenerated.orderSum:dTLB-store-misses:u                    true  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernGenerated.orderSum:dTLB-stores:u                          true  avgt         13.103              #/op
joernBench.JoernGenerated.orderSum:iTLB-load-misses:u                     true  avgt          0.001              #/op
joernBench.JoernGenerated.orderSum:iTLB-loads:u                           true  avgt          0.009              #/op
joernBench.JoernGenerated.orderSum:instructions:u                         true  avgt        184.203              #/op
joernBench.JoernGenerated.orderSum:·gc.alloc.rate                         true  avgt    5    ≈ 10⁻³            MB/sec
joernBench.JoernGenerated.orderSum:·gc.alloc.rate.norm                    true  avgt    5    ≈ 10⁻⁴              B/op
joernBench.JoernGenerated.orderSum:·gc.count                              true  avgt    5       ≈ 0            counts
joernBench.JoernGenerated.orderSum                                       false  avgt    5    35.262 ±   1.276   ns/op
joernBench.JoernGenerated.orderSum:L1-dcache-load-misses:u               false  avgt          2.713              #/op
joernBench.JoernGenerated.orderSum:L1-dcache-loads:u                     false  avgt         50.769              #/op
joernBench.JoernGenerated.orderSum:L1-dcache-stores:u                    false  avgt         11.339              #/op
joernBench.JoernGenerated.orderSum:L1-icache-load-misses:u               false  avgt          0.021              #/op
joernBench.JoernGenerated.orderSum:LLC-load-misses:u                     false  avgt          1.002              #/op
joernBench.JoernGenerated.orderSum:LLC-loads:u                           false  avgt          1.056              #/op
joernBench.JoernGenerated.orderSum:LLC-store-misses:u                    false  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernGenerated.orderSum:LLC-stores:u                          false  avgt          0.001              #/op
joernBench.JoernGenerated.orderSum:branch-misses:u                       false  avgt          0.494              #/op
joernBench.JoernGenerated.orderSum:branches:u                            false  avgt         43.627              #/op
joernBench.JoernGenerated.orderSum:cycles:u                              false  avgt        166.855              #/op
joernBench.JoernGenerated.orderSum:dTLB-load-misses:u                    false  avgt         ≈ 10⁻³              #/op
joernBench.JoernGenerated.orderSum:dTLB-loads:u                          false  avgt         50.530              #/op
joernBench.JoernGenerated.orderSum:dTLB-store-misses:u                   false  avgt         ≈ 10⁻⁵              #/op
joernBench.JoernGenerated.orderSum:dTLB-stores:u                         false  avgt         11.277              #/op
joernBench.JoernGenerated.orderSum:iTLB-load-misses:u                    false  avgt          0.001              #/op
joernBench.JoernGenerated.orderSum:iTLB-loads:u                          false  avgt          0.029              #/op
joernBench.JoernGenerated.orderSum:instructions:u                        false  avgt        178.653              #/op
joernBench.JoernGenerated.orderSum:·gc.alloc.rate                        false  avgt    5     0.001 ±   0.001  MB/sec
joernBench.JoernGenerated.orderSum:·gc.alloc.rate.norm                   false  avgt    5    ≈ 10⁻⁵              B/op
joernBench.JoernGenerated.orderSum:·gc.count                             false  avgt    5       ≈ 0            counts
joernBench.JoernLegacy.astDFS                                             true  avgt    5    87.203 ±   4.513   ns/op
joernBench.JoernLegacy.astDFS:L1-dcache-load-misses:u                     true  avgt          6.277              #/op
joernBench.JoernLegacy.astDFS:L1-dcache-loads:u                           true  avgt        169.799              #/op
joernBench.JoernLegacy.astDFS:L1-dcache-stores:u                          true  avgt         70.953              #/op
joernBench.JoernLegacy.astDFS:L1-icache-load-misses:u                     true  avgt          0.147              #/op
joernBench.JoernLegacy.astDFS:LLC-load-misses:u                           true  avgt          0.952              #/op
joernBench.JoernLegacy.astDFS:LLC-loads:u                                 true  avgt          1.129              #/op
joernBench.JoernLegacy.astDFS:LLC-store-misses:u                          true  avgt          0.022              #/op
joernBench.JoernLegacy.astDFS:LLC-stores:u                                true  avgt          0.247              #/op
joernBench.JoernLegacy.astDFS:branch-misses:u                             true  avgt          0.785              #/op
joernBench.JoernLegacy.astDFS:branches:u                                  true  avgt         98.806              #/op
joernBench.JoernLegacy.astDFS:cycles:u                                    true  avgt        456.332              #/op
joernBench.JoernLegacy.astDFS:dTLB-load-misses:u                          true  avgt          0.003              #/op
joernBench.JoernLegacy.astDFS:dTLB-loads:u                                true  avgt        171.929              #/op
joernBench.JoernLegacy.astDFS:dTLB-store-misses:u                         true  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernLegacy.astDFS:dTLB-stores:u                               true  avgt         71.552              #/op
joernBench.JoernLegacy.astDFS:iTLB-load-misses:u                          true  avgt         ≈ 10⁻³              #/op
joernBench.JoernLegacy.astDFS:iTLB-loads:u                                true  avgt          0.004              #/op
joernBench.JoernLegacy.astDFS:instructions:u                              true  avgt        579.739              #/op
joernBench.JoernLegacy.astDFS:·gc.alloc.rate                              true  avgt    5  1053.974 ±  53.761  MB/sec
joernBench.JoernLegacy.astDFS:·gc.alloc.rate.norm                         true  avgt    5    96.368 ±   0.002    B/op
joernBench.JoernLegacy.astDFS:·gc.count                                   true  avgt    5     7.000            counts
joernBench.JoernLegacy.astDFS:·gc.time                                    true  avgt    5    91.000                ms
joernBench.JoernLegacy.astDFS                                            false  avgt    5    81.741 ±   6.036   ns/op
joernBench.JoernLegacy.astDFS:L1-dcache-load-misses:u                    false  avgt          5.593              #/op
joernBench.JoernLegacy.astDFS:L1-dcache-loads:u                          false  avgt        138.012              #/op
joernBench.JoernLegacy.astDFS:L1-dcache-stores:u                         false  avgt         52.199              #/op
joernBench.JoernLegacy.astDFS:L1-icache-load-misses:u                    false  avgt          0.097              #/op
joernBench.JoernLegacy.astDFS:LLC-load-misses:u                          false  avgt          0.898              #/op
joernBench.JoernLegacy.astDFS:LLC-loads:u                                false  avgt          1.069              #/op
joernBench.JoernLegacy.astDFS:LLC-store-misses:u                         false  avgt          0.009              #/op
joernBench.JoernLegacy.astDFS:LLC-stores:u                               false  avgt          0.140              #/op
joernBench.JoernLegacy.astDFS:branch-misses:u                            false  avgt          0.658              #/op
joernBench.JoernLegacy.astDFS:branches:u                                 false  avgt         81.636              #/op
joernBench.JoernLegacy.astDFS:cycles:u                                   false  avgt        381.923              #/op
joernBench.JoernLegacy.astDFS:dTLB-load-misses:u                         false  avgt          0.020              #/op
joernBench.JoernLegacy.astDFS:dTLB-loads:u                               false  avgt        138.668              #/op
joernBench.JoernLegacy.astDFS:dTLB-store-misses:u                        false  avgt         ≈ 10⁻³              #/op
joernBench.JoernLegacy.astDFS:dTLB-stores:u                              false  avgt         52.308              #/op
joernBench.JoernLegacy.astDFS:iTLB-load-misses:u                         false  avgt         ≈ 10⁻³              #/op
joernBench.JoernLegacy.astDFS:iTLB-loads:u                               false  avgt          0.003              #/op
joernBench.JoernLegacy.astDFS:instructions:u                             false  avgt        475.773              #/op
joernBench.JoernLegacy.astDFS:·gc.alloc.rate                             false  avgt    5   937.834 ±  67.946  MB/sec
joernBench.JoernLegacy.astDFS:·gc.alloc.rate.norm                        false  avgt    5    80.367 ±   0.002    B/op
joernBench.JoernLegacy.astDFS:·gc.count                                  false  avgt    5     4.000            counts
joernBench.JoernLegacy.astDFS:·gc.time                                   false  avgt    5     5.000                ms
joernBench.JoernLegacy.astUp                                              true  avgt    5   108.643 ±   2.899   ns/op
joernBench.JoernLegacy.astUp:L1-dcache-load-misses:u                      true  avgt          7.403              #/op
joernBench.JoernLegacy.astUp:L1-dcache-loads:u                            true  avgt        151.612              #/op
joernBench.JoernLegacy.astUp:L1-dcache-stores:u                           true  avgt         82.184              #/op
joernBench.JoernLegacy.astUp:L1-icache-load-misses:u                      true  avgt          0.088              #/op
joernBench.JoernLegacy.astUp:LLC-load-misses:u                            true  avgt          1.213              #/op
joernBench.JoernLegacy.astUp:LLC-loads:u                                  true  avgt          2.304              #/op
joernBench.JoernLegacy.astUp:LLC-store-misses:u                           true  avgt          0.016              #/op
joernBench.JoernLegacy.astUp:LLC-stores:u                                 true  avgt          0.248              #/op
joernBench.JoernLegacy.astUp:branch-misses:u                              true  avgt          1.004              #/op
joernBench.JoernLegacy.astUp:branches:u                                   true  avgt        104.541              #/op
joernBench.JoernLegacy.astUp:cycles:u                                     true  avgt        526.896              #/op
joernBench.JoernLegacy.astUp:dTLB-load-misses:u                           true  avgt          0.007              #/op
joernBench.JoernLegacy.astUp:dTLB-loads:u                                 true  avgt        151.789              #/op
joernBench.JoernLegacy.astUp:dTLB-store-misses:u                          true  avgt         ≈ 10⁻³              #/op
joernBench.JoernLegacy.astUp:dTLB-stores:u                                true  avgt         82.308              #/op
joernBench.JoernLegacy.astUp:iTLB-load-misses:u                           true  avgt          0.002              #/op
joernBench.JoernLegacy.astUp:iTLB-loads:u                                 true  avgt          0.048              #/op
joernBench.JoernLegacy.astUp:instructions:u                               true  avgt        537.901              #/op
joernBench.JoernLegacy.astUp:·gc.alloc.rate                               true  avgt    5   952.281 ±  25.316  MB/sec
joernBench.JoernLegacy.astUp:·gc.alloc.rate.norm                          true  avgt    5   108.485 ±   0.001    B/op
joernBench.JoernLegacy.astUp:·gc.count                                    true  avgt    5     9.000            counts
joernBench.JoernLegacy.astUp:·gc.time                                     true  avgt    5   389.000                ms
joernBench.JoernLegacy.astUp                                             false  avgt    5    41.546 ±   1.772   ns/op
joernBench.JoernLegacy.astUp:L1-dcache-load-misses:u                     false  avgt          2.907              #/op
joernBench.JoernLegacy.astUp:L1-dcache-loads:u                           false  avgt        151.328              #/op
joernBench.JoernLegacy.astUp:L1-dcache-stores:u                          false  avgt         77.960              #/op
joernBench.JoernLegacy.astUp:L1-icache-load-misses:u                     false  avgt          0.029              #/op
joernBench.JoernLegacy.astUp:LLC-load-misses:u                           false  avgt          0.027              #/op
joernBench.JoernLegacy.astUp:LLC-loads:u                                 false  avgt          0.088              #/op
joernBench.JoernLegacy.astUp:LLC-store-misses:u                          false  avgt          0.027              #/op
joernBench.JoernLegacy.astUp:LLC-stores:u                                false  avgt          0.234              #/op
joernBench.JoernLegacy.astUp:branch-misses:u                             false  avgt          0.961              #/op
joernBench.JoernLegacy.astUp:branches:u                                  false  avgt        105.039              #/op
joernBench.JoernLegacy.astUp:cycles:u                                    false  avgt        214.601              #/op
joernBench.JoernLegacy.astUp:dTLB-load-misses:u                          false  avgt          0.008              #/op
joernBench.JoernLegacy.astUp:dTLB-loads:u                                false  avgt        151.275              #/op
joernBench.JoernLegacy.astUp:dTLB-store-misses:u                         false  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernLegacy.astUp:dTLB-stores:u                               false  avgt         78.248              #/op
joernBench.JoernLegacy.astUp:iTLB-load-misses:u                          false  avgt         ≈ 10⁻³              #/op
joernBench.JoernLegacy.astUp:iTLB-loads:u                                false  avgt          0.034              #/op
joernBench.JoernLegacy.astUp:instructions:u                              false  avgt        526.654              #/op
joernBench.JoernLegacy.astUp:·gc.alloc.rate                              false  avgt    5  2490.344 ± 105.257  MB/sec
joernBench.JoernLegacy.astUp:·gc.alloc.rate.norm                         false  avgt    5   108.485 ±   0.001    B/op
joernBench.JoernLegacy.astUp:·gc.count                                   false  avgt    5    21.000            counts
joernBench.JoernLegacy.astUp:·gc.time                                    false  avgt    5   111.000                ms
joernBench.JoernLegacy.orderSum                                           true  avgt    5    59.365 ±   2.490   ns/op
joernBench.JoernLegacy.orderSum:L1-dcache-load-misses:u                   true  avgt          3.883              #/op
joernBench.JoernLegacy.orderSum:L1-dcache-loads:u                         true  avgt         31.238              #/op
joernBench.JoernLegacy.orderSum:L1-dcache-stores:u                        true  avgt         16.114              #/op
joernBench.JoernLegacy.orderSum:L1-icache-load-misses:u                   true  avgt          0.025              #/op
joernBench.JoernLegacy.orderSum:LLC-load-misses:u                         true  avgt          2.250              #/op
joernBench.JoernLegacy.orderSum:LLC-loads:u                               true  avgt          2.381              #/op
joernBench.JoernLegacy.orderSum:LLC-store-misses:u                        true  avgt          0.002              #/op
joernBench.JoernLegacy.orderSum:LLC-stores:u                              true  avgt          0.006              #/op
joernBench.JoernLegacy.orderSum:branch-misses:u                           true  avgt          0.843              #/op
joernBench.JoernLegacy.orderSum:branches:u                                true  avgt         16.216              #/op
joernBench.JoernLegacy.orderSum:cycles:u                                  true  avgt        283.666              #/op
joernBench.JoernLegacy.orderSum:dTLB-load-misses:u                        true  avgt          0.002              #/op
joernBench.JoernLegacy.orderSum:dTLB-loads:u                              true  avgt         31.351              #/op
joernBench.JoernLegacy.orderSum:dTLB-store-misses:u                       true  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernLegacy.orderSum:dTLB-stores:u                             true  avgt         16.286              #/op
joernBench.JoernLegacy.orderSum:iTLB-load-misses:u                        true  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernLegacy.orderSum:iTLB-loads:u                              true  avgt          0.001              #/op
joernBench.JoernLegacy.orderSum:instructions:u                            true  avgt         93.478              #/op
joernBench.JoernLegacy.orderSum:·gc.alloc.rate                            true  avgt    5     1.494 ±   0.063  MB/sec
joernBench.JoernLegacy.orderSum:·gc.alloc.rate.norm                       true  avgt    5     0.093 ±   0.001    B/op
joernBench.JoernLegacy.orderSum:·gc.count                                 true  avgt    5       ≈ 0            counts
joernBench.JoernLegacy.orderSum                                          false  avgt    5    28.425 ±   0.889   ns/op
joernBench.JoernLegacy.orderSum:L1-dcache-load-misses:u                  false  avgt          2.702              #/op
joernBench.JoernLegacy.orderSum:L1-dcache-loads:u                        false  avgt         31.131              #/op
joernBench.JoernLegacy.orderSum:L1-dcache-stores:u                       false  avgt         16.600              #/op
joernBench.JoernLegacy.orderSum:L1-icache-load-misses:u                  false  avgt          0.008              #/op
joernBench.JoernLegacy.orderSum:LLC-load-misses:u                        false  avgt          1.070              #/op
joernBench.JoernLegacy.orderSum:LLC-loads:u                              false  avgt          1.139              #/op
joernBench.JoernLegacy.orderSum:LLC-store-misses:u                       false  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernLegacy.orderSum:LLC-stores:u                             false  avgt          0.002              #/op
joernBench.JoernLegacy.orderSum:branch-misses:u                          false  avgt          0.442              #/op
joernBench.JoernLegacy.orderSum:branches:u                               false  avgt         17.161              #/op
joernBench.JoernLegacy.orderSum:cycles:u                                 false  avgt        134.657              #/op
joernBench.JoernLegacy.orderSum:dTLB-load-misses:u                       false  avgt         ≈ 10⁻³              #/op
joernBench.JoernLegacy.orderSum:dTLB-loads:u                             false  avgt         31.062              #/op
joernBench.JoernLegacy.orderSum:dTLB-store-misses:u                      false  avgt         ≈ 10⁻⁴              #/op
joernBench.JoernLegacy.orderSum:dTLB-stores:u                            false  avgt         16.647              #/op
joernBench.JoernLegacy.orderSum:iTLB-load-misses:u                       false  avgt         ≈ 10⁻³              #/op
joernBench.JoernLegacy.orderSum:iTLB-loads:u                             false  avgt          0.002              #/op
joernBench.JoernLegacy.orderSum:instructions:u                           false  avgt         95.298              #/op
joernBench.JoernLegacy.orderSum:·gc.alloc.rate                           false  avgt    5     3.120 ±   0.097  MB/sec
joernBench.JoernLegacy.orderSum:·gc.alloc.rate.norm                      false  avgt    5     0.093 ±   0.001    B/op
joernBench.JoernLegacy.orderSum:·gc.count                                false  avgt    5       ≈ 0            counts
joernBench.Odb2Generated.astDFS                                           true  avgt    5    22.514 ±   0.547   ns/op
joernBench.Odb2Generated.astDFS:L1-dcache-load-misses:u                   true  avgt          1.619              #/op
joernBench.Odb2Generated.astDFS:L1-dcache-loads:u                         true  avgt         82.511              #/op
joernBench.Odb2Generated.astDFS:L1-dcache-stores:u                        true  avgt         33.803              #/op
joernBench.Odb2Generated.astDFS:L1-icache-load-misses:u                   true  avgt          0.028              #/op
joernBench.Odb2Generated.astDFS:LLC-load-misses:u                         true  avgt          0.064              #/op
joernBench.Odb2Generated.astDFS:LLC-loads:u                               true  avgt          0.115              #/op
joernBench.Odb2Generated.astDFS:LLC-store-misses:u                        true  avgt          0.019              #/op
joernBench.Odb2Generated.astDFS:LLC-stores:u                              true  avgt          0.086              #/op
joernBench.Odb2Generated.astDFS:branch-misses:u                           true  avgt          0.456              #/op
joernBench.Odb2Generated.astDFS:branches:u                                true  avgt         41.440              #/op
joernBench.Odb2Generated.astDFS:cycles:u                                  true  avgt        107.243              #/op
joernBench.Odb2Generated.astDFS:dTLB-load-misses:u                        true  avgt          0.001              #/op
joernBench.Odb2Generated.astDFS:dTLB-loads:u                              true  avgt         81.789              #/op
joernBench.Odb2Generated.astDFS:dTLB-store-misses:u                       true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.astDFS:dTLB-stores:u                             true  avgt         33.661              #/op
joernBench.Odb2Generated.astDFS:iTLB-load-misses:u                        true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.astDFS:iTLB-loads:u                              true  avgt          0.001              #/op
joernBench.Odb2Generated.astDFS:instructions:u                            true  avgt        279.079              #/op
joernBench.Odb2Generated.astDFS:·gc.alloc.rate                            true  avgt    5  2543.852 ±  61.492  MB/sec
joernBench.Odb2Generated.astDFS:·gc.alloc.rate.norm                       true  avgt    5    60.058 ±   0.001    B/op
joernBench.Odb2Generated.astDFS:·gc.count                                 true  avgt    5     8.000            counts
joernBench.Odb2Generated.astDFS:·gc.time                                  true  avgt    5     7.000                ms
joernBench.Odb2Generated.astDFS                                          false  avgt    5    22.240 ±   0.212   ns/op
joernBench.Odb2Generated.astDFS:L1-dcache-load-misses:u                  false  avgt          1.614              #/op
joernBench.Odb2Generated.astDFS:L1-dcache-loads:u                        false  avgt         80.138              #/op
joernBench.Odb2Generated.astDFS:L1-dcache-stores:u                       false  avgt         33.550              #/op
joernBench.Odb2Generated.astDFS:L1-icache-load-misses:u                  false  avgt          0.019              #/op
joernBench.Odb2Generated.astDFS:LLC-load-misses:u                        false  avgt          0.067              #/op
joernBench.Odb2Generated.astDFS:LLC-loads:u                              false  avgt          0.116              #/op
joernBench.Odb2Generated.astDFS:LLC-store-misses:u                       false  avgt          0.018              #/op
joernBench.Odb2Generated.astDFS:LLC-stores:u                             false  avgt          0.083              #/op
joernBench.Odb2Generated.astDFS:branch-misses:u                          false  avgt          0.451              #/op
joernBench.Odb2Generated.astDFS:branches:u                               false  avgt         39.169              #/op
joernBench.Odb2Generated.astDFS:cycles:u                                 false  avgt        106.730              #/op
joernBench.Odb2Generated.astDFS:dTLB-load-misses:u                       false  avgt          0.002              #/op
joernBench.Odb2Generated.astDFS:dTLB-loads:u                             false  avgt         79.337              #/op
joernBench.Odb2Generated.astDFS:dTLB-store-misses:u                      false  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.astDFS:dTLB-stores:u                            false  avgt         33.180              #/op
joernBench.Odb2Generated.astDFS:iTLB-load-misses:u                       false  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.astDFS:iTLB-loads:u                             false  avgt         ≈ 10⁻³              #/op
joernBench.Odb2Generated.astDFS:instructions:u                           false  avgt        275.898              #/op
joernBench.Odb2Generated.astDFS:·gc.alloc.rate                           false  avgt    5  2575.129 ±  24.629  MB/sec
joernBench.Odb2Generated.astDFS:·gc.alloc.rate.norm                      false  avgt    5    60.058 ±   0.001    B/op
joernBench.Odb2Generated.astDFS:·gc.count                                false  avgt    5     8.000            counts
joernBench.Odb2Generated.astDFS:·gc.time                                 false  avgt    5     7.000                ms
joernBench.Odb2Generated.astUp                                            true  avgt    5    45.218 ±  11.846   ns/op
joernBench.Odb2Generated.astUp:L1-dcache-load-misses:u                    true  avgt          3.032              #/op
joernBench.Odb2Generated.astUp:L1-dcache-loads:u                          true  avgt         48.084              #/op
joernBench.Odb2Generated.astUp:L1-dcache-stores:u                         true  avgt         23.749              #/op
joernBench.Odb2Generated.astUp:L1-icache-load-misses:u                    true  avgt          0.012              #/op
joernBench.Odb2Generated.astUp:LLC-load-misses:u                          true  avgt          0.400              #/op
joernBench.Odb2Generated.astUp:LLC-loads:u                                true  avgt          1.433              #/op
joernBench.Odb2Generated.astUp:LLC-store-misses:u                         true  avgt          0.056              #/op
joernBench.Odb2Generated.astUp:LLC-stores:u                               true  avgt          0.075              #/op
joernBench.Odb2Generated.astUp:branch-misses:u                            true  avgt          0.084              #/op
joernBench.Odb2Generated.astUp:branches:u                                 true  avgt         24.112              #/op
joernBench.Odb2Generated.astUp:cycles:u                                   true  avgt        211.258              #/op
joernBench.Odb2Generated.astUp:dTLB-load-misses:u                         true  avgt         ≈ 10⁻³              #/op
joernBench.Odb2Generated.astUp:dTLB-loads:u                               true  avgt         48.045              #/op
joernBench.Odb2Generated.astUp:dTLB-store-misses:u                        true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.astUp:dTLB-stores:u                              true  avgt         23.772              #/op
joernBench.Odb2Generated.astUp:iTLB-load-misses:u                         true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.astUp:iTLB-loads:u                               true  avgt         ≈ 10⁻³              #/op
joernBench.Odb2Generated.astUp:instructions:u                             true  avgt        167.151              #/op
joernBench.Odb2Generated.astUp:·gc.alloc.rate                             true  avgt    5   784.627 ± 202.336  MB/sec
joernBench.Odb2Generated.astUp:·gc.alloc.rate.norm                        true  avgt    5    37.069 ±   0.001    B/op
joernBench.Odb2Generated.astUp:·gc.count                                  true  avgt    5     3.000            counts
joernBench.Odb2Generated.astUp:·gc.time                                   true  avgt    5     3.000                ms
joernBench.Odb2Generated.astUp                                           false  avgt    5    11.053 ±   0.691   ns/op
joernBench.Odb2Generated.astUp:L1-dcache-load-misses:u                   false  avgt          0.713              #/op
joernBench.Odb2Generated.astUp:L1-dcache-loads:u                         false  avgt         48.000              #/op
joernBench.Odb2Generated.astUp:L1-dcache-stores:u                        false  avgt         23.695              #/op
joernBench.Odb2Generated.astUp:L1-icache-load-misses:u                   false  avgt          0.005              #/op
joernBench.Odb2Generated.astUp:LLC-load-misses:u                         false  avgt          0.016              #/op
joernBench.Odb2Generated.astUp:LLC-loads:u                               false  avgt          0.032              #/op
joernBench.Odb2Generated.astUp:LLC-store-misses:u                        false  avgt          0.007              #/op
joernBench.Odb2Generated.astUp:LLC-stores:u                              false  avgt          0.044              #/op
joernBench.Odb2Generated.astUp:branch-misses:u                           false  avgt          0.055              #/op
joernBench.Odb2Generated.astUp:branches:u                                false  avgt         23.155              #/op
joernBench.Odb2Generated.astUp:cycles:u                                  false  avgt         52.171              #/op
joernBench.Odb2Generated.astUp:dTLB-load-misses:u                        false  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.astUp:dTLB-loads:u                              false  avgt         47.879              #/op
joernBench.Odb2Generated.astUp:dTLB-store-misses:u                       false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.astUp:dTLB-stores:u                             false  avgt         23.766              #/op
joernBench.Odb2Generated.astUp:iTLB-load-misses:u                        false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.astUp:iTLB-loads:u                              false  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.astUp:instructions:u                            false  avgt        164.968              #/op
joernBench.Odb2Generated.astUp:·gc.alloc.rate                            false  avgt    5  3198.821 ± 196.295  MB/sec
joernBench.Odb2Generated.astUp:·gc.alloc.rate.norm                       false  avgt    5    37.069 ±   0.001    B/op
joernBench.Odb2Generated.astUp:·gc.count                                 false  avgt    5    10.000            counts
joernBench.Odb2Generated.astUp:·gc.time                                  false  avgt    5     9.000                ms
joernBench.Odb2Generated.orderSumChecked                                  true  avgt    5    53.329 ±   0.708   ns/op
joernBench.Odb2Generated.orderSumChecked:L1-dcache-load-misses:u          true  avgt          5.046              #/op
joernBench.Odb2Generated.orderSumChecked:L1-dcache-loads:u                true  avgt         27.028              #/op
joernBench.Odb2Generated.orderSumChecked:L1-dcache-stores:u               true  avgt          5.001              #/op
joernBench.Odb2Generated.orderSumChecked:L1-icache-load-misses:u          true  avgt          0.002              #/op
joernBench.Odb2Generated.orderSumChecked:LLC-load-misses:u                true  avgt          2.216              #/op
joernBench.Odb2Generated.orderSumChecked:LLC-loads:u                      true  avgt          3.187              #/op
joernBench.Odb2Generated.orderSumChecked:LLC-store-misses:u               true  avgt          0.001              #/op
joernBench.Odb2Generated.orderSumChecked:LLC-stores:u                     true  avgt          0.002              #/op
joernBench.Odb2Generated.orderSumChecked:branch-misses:u                  true  avgt          0.006              #/op
joernBench.Odb2Generated.orderSumChecked:branches:u                       true  avgt         15.060              #/op
joernBench.Odb2Generated.orderSumChecked:cycles:u                         true  avgt        253.123              #/op
joernBench.Odb2Generated.orderSumChecked:dTLB-load-misses:u               true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumChecked:dTLB-loads:u                     true  avgt         27.161              #/op
joernBench.Odb2Generated.orderSumChecked:dTLB-store-misses:u              true  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumChecked:dTLB-stores:u                    true  avgt          5.088              #/op
joernBench.Odb2Generated.orderSumChecked:iTLB-load-misses:u               true  avgt          0.001              #/op
joernBench.Odb2Generated.orderSumChecked:iTLB-loads:u                     true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumChecked:instructions:u                   true  avgt         94.316              #/op
joernBench.Odb2Generated.orderSumChecked:·gc.alloc.rate                   true  avgt    5     0.001 ±   0.001  MB/sec
joernBench.Odb2Generated.orderSumChecked:·gc.alloc.rate.norm              true  avgt    5    ≈ 10⁻⁴              B/op
joernBench.Odb2Generated.orderSumChecked:·gc.count                        true  avgt    5       ≈ 0            counts
joernBench.Odb2Generated.orderSumChecked                                 false  avgt    5     6.260 ±   0.238   ns/op
joernBench.Odb2Generated.orderSumChecked:L1-dcache-load-misses:u         false  avgt          0.576              #/op
joernBench.Odb2Generated.orderSumChecked:L1-dcache-loads:u               false  avgt         26.904              #/op
joernBench.Odb2Generated.orderSumChecked:L1-dcache-stores:u              false  avgt          4.996              #/op
joernBench.Odb2Generated.orderSumChecked:L1-icache-load-misses:u         false  avgt          0.004              #/op
joernBench.Odb2Generated.orderSumChecked:LLC-load-misses:u               false  avgt          0.018              #/op
joernBench.Odb2Generated.orderSumChecked:LLC-loads:u                     false  avgt          0.034              #/op
joernBench.Odb2Generated.orderSumChecked:LLC-store-misses:u              false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumChecked:LLC-stores:u                    false  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumChecked:branch-misses:u                 false  avgt          0.001              #/op
joernBench.Odb2Generated.orderSumChecked:branches:u                      false  avgt         14.954              #/op
joernBench.Odb2Generated.orderSumChecked:cycles:u                        false  avgt         29.742              #/op
joernBench.Odb2Generated.orderSumChecked:dTLB-load-misses:u              false  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumChecked:dTLB-loads:u                    false  avgt         26.956              #/op
joernBench.Odb2Generated.orderSumChecked:dTLB-store-misses:u             false  avgt         ≈ 10⁻⁶              #/op
joernBench.Odb2Generated.orderSumChecked:dTLB-stores:u                   false  avgt          5.005              #/op
joernBench.Odb2Generated.orderSumChecked:iTLB-load-misses:u              false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumChecked:iTLB-loads:u                    false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumChecked:instructions:u                  false  avgt         98.838              #/op
joernBench.Odb2Generated.orderSumChecked:·gc.alloc.rate                  false  avgt    5     0.004 ±   0.001  MB/sec
joernBench.Odb2Generated.orderSumChecked:·gc.alloc.rate.norm             false  avgt    5    ≈ 10⁻⁵              B/op
joernBench.Odb2Generated.orderSumChecked:·gc.count                       false  avgt    5       ≈ 0            counts
joernBench.Odb2Generated.orderSumExplicit                                 true  avgt    5    49.330 ±   3.487   ns/op
joernBench.Odb2Generated.orderSumExplicit:L1-dcache-load-misses:u         true  avgt          4.800              #/op
joernBench.Odb2Generated.orderSumExplicit:L1-dcache-loads:u               true  avgt         22.016              #/op
joernBench.Odb2Generated.orderSumExplicit:L1-dcache-stores:u              true  avgt          3.087              #/op
joernBench.Odb2Generated.orderSumExplicit:L1-icache-load-misses:u         true  avgt          0.019              #/op
joernBench.Odb2Generated.orderSumExplicit:LLC-load-misses:u               true  avgt          2.204              #/op
joernBench.Odb2Generated.orderSumExplicit:LLC-loads:u                     true  avgt          3.210              #/op
joernBench.Odb2Generated.orderSumExplicit:LLC-store-misses:u              true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumExplicit:LLC-stores:u                    true  avgt          0.001              #/op
joernBench.Odb2Generated.orderSumExplicit:branch-misses:u                 true  avgt          0.007              #/op
joernBench.Odb2Generated.orderSumExplicit:branches:u                      true  avgt         12.999              #/op
joernBench.Odb2Generated.orderSumExplicit:cycles:u                        true  avgt        232.966              #/op
joernBench.Odb2Generated.orderSumExplicit:dTLB-load-misses:u              true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumExplicit:dTLB-loads:u                    true  avgt         21.946              #/op
joernBench.Odb2Generated.orderSumExplicit:dTLB-store-misses:u             true  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumExplicit:dTLB-stores:u                   true  avgt          3.023              #/op
joernBench.Odb2Generated.orderSumExplicit:iTLB-load-misses:u              true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumExplicit:iTLB-loads:u                    true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumExplicit:instructions:u                  true  avgt         77.035              #/op
joernBench.Odb2Generated.orderSumExplicit:·gc.alloc.rate                  true  avgt    5     0.001 ±   0.001  MB/sec
joernBench.Odb2Generated.orderSumExplicit:·gc.alloc.rate.norm             true  avgt    5    ≈ 10⁻⁵              B/op
joernBench.Odb2Generated.orderSumExplicit:·gc.count                       true  avgt    5       ≈ 0            counts
joernBench.Odb2Generated.orderSumExplicit                                false  avgt    5     5.537 ±   0.270   ns/op
joernBench.Odb2Generated.orderSumExplicit:L1-dcache-load-misses:u        false  avgt          0.574              #/op
joernBench.Odb2Generated.orderSumExplicit:L1-dcache-loads:u              false  avgt         21.951              #/op
joernBench.Odb2Generated.orderSumExplicit:L1-dcache-stores:u             false  avgt          2.991              #/op
joernBench.Odb2Generated.orderSumExplicit:L1-icache-load-misses:u        false  avgt          0.003              #/op
joernBench.Odb2Generated.orderSumExplicit:LLC-load-misses:u              false  avgt          0.017              #/op
joernBench.Odb2Generated.orderSumExplicit:LLC-loads:u                    false  avgt          0.032              #/op
joernBench.Odb2Generated.orderSumExplicit:LLC-store-misses:u             false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumExplicit:LLC-stores:u                   false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumExplicit:branch-misses:u                false  avgt          0.001              #/op
joernBench.Odb2Generated.orderSumExplicit:branches:u                     false  avgt         12.978              #/op
joernBench.Odb2Generated.orderSumExplicit:cycles:u                       false  avgt         26.086              #/op
joernBench.Odb2Generated.orderSumExplicit:dTLB-load-misses:u             false  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumExplicit:dTLB-loads:u                   false  avgt         21.866              #/op
joernBench.Odb2Generated.orderSumExplicit:dTLB-store-misses:u            false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumExplicit:dTLB-stores:u                  false  avgt          2.995              #/op
joernBench.Odb2Generated.orderSumExplicit:iTLB-load-misses:u             false  avgt         ≈ 10⁻⁶              #/op
joernBench.Odb2Generated.orderSumExplicit:iTLB-loads:u                   false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumExplicit:instructions:u                 false  avgt         74.847              #/op
joernBench.Odb2Generated.orderSumExplicit:·gc.alloc.rate                 false  avgt    5     0.003 ±   0.001  MB/sec
joernBench.Odb2Generated.orderSumExplicit:·gc.alloc.rate.norm            false  avgt    5    ≈ 10⁻⁵              B/op
joernBench.Odb2Generated.orderSumExplicit:·gc.count                      false  avgt    5       ≈ 0            counts
joernBench.Odb2Generated.orderSumUnchecked                                true  avgt    5    53.989 ±  10.291   ns/op
joernBench.Odb2Generated.orderSumUnchecked:L1-dcache-load-misses:u        true  avgt          4.996              #/op
joernBench.Odb2Generated.orderSumUnchecked:L1-dcache-loads:u              true  avgt         25.239              #/op
joernBench.Odb2Generated.orderSumUnchecked:L1-dcache-stores:u             true  avgt          5.114              #/op
joernBench.Odb2Generated.orderSumUnchecked:L1-icache-load-misses:u        true  avgt          0.027              #/op
joernBench.Odb2Generated.orderSumUnchecked:LLC-load-misses:u              true  avgt          2.334              #/op
joernBench.Odb2Generated.orderSumUnchecked:LLC-loads:u                    true  avgt          3.234              #/op
joernBench.Odb2Generated.orderSumUnchecked:LLC-store-misses:u             true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumUnchecked:LLC-stores:u                   true  avgt          0.001              #/op
joernBench.Odb2Generated.orderSumUnchecked:branch-misses:u                true  avgt          0.009              #/op
joernBench.Odb2Generated.orderSumUnchecked:branches:u                     true  avgt         14.102              #/op
joernBench.Odb2Generated.orderSumUnchecked:cycles:u                       true  avgt        254.846              #/op
joernBench.Odb2Generated.orderSumUnchecked:dTLB-load-misses:u             true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumUnchecked:dTLB-loads:u                   true  avgt         25.183              #/op
joernBench.Odb2Generated.orderSumUnchecked:dTLB-store-misses:u            true  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumUnchecked:dTLB-stores:u                  true  avgt          5.045              #/op
joernBench.Odb2Generated.orderSumUnchecked:iTLB-load-misses:u             true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumUnchecked:iTLB-loads:u                   true  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumUnchecked:instructions:u                 true  avgt         88.498              #/op
joernBench.Odb2Generated.orderSumUnchecked:·gc.alloc.rate                 true  avgt    5     0.001 ±   0.001  MB/sec
joernBench.Odb2Generated.orderSumUnchecked:·gc.alloc.rate.norm            true  avgt    5    ≈ 10⁻⁴              B/op
joernBench.Odb2Generated.orderSumUnchecked:·gc.count                      true  avgt    5       ≈ 0            counts
joernBench.Odb2Generated.orderSumUnchecked                               false  avgt    5     5.945 ±   0.708   ns/op
joernBench.Odb2Generated.orderSumUnchecked:L1-dcache-load-misses:u       false  avgt          0.576              #/op
joernBench.Odb2Generated.orderSumUnchecked:L1-dcache-loads:u             false  avgt         24.942              #/op
joernBench.Odb2Generated.orderSumUnchecked:L1-dcache-stores:u            false  avgt          5.007              #/op
joernBench.Odb2Generated.orderSumUnchecked:L1-icache-load-misses:u       false  avgt          0.003              #/op
joernBench.Odb2Generated.orderSumUnchecked:LLC-load-misses:u             false  avgt          0.015              #/op
joernBench.Odb2Generated.orderSumUnchecked:LLC-loads:u                   false  avgt          0.030              #/op
joernBench.Odb2Generated.orderSumUnchecked:LLC-store-misses:u            false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumUnchecked:LLC-stores:u                  false  avgt         ≈ 10⁻⁴              #/op
joernBench.Odb2Generated.orderSumUnchecked:branch-misses:u               false  avgt          0.001              #/op
joernBench.Odb2Generated.orderSumUnchecked:branches:u                    false  avgt         13.953              #/op
joernBench.Odb2Generated.orderSumUnchecked:cycles:u                      false  avgt         27.809              #/op
joernBench.Odb2Generated.orderSumUnchecked:dTLB-load-misses:u            false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumUnchecked:dTLB-loads:u                  false  avgt         24.944              #/op
joernBench.Odb2Generated.orderSumUnchecked:dTLB-store-misses:u           false  avgt         ≈ 10⁻⁶              #/op
joernBench.Odb2Generated.orderSumUnchecked:dTLB-stores:u                 false  avgt          5.008              #/op
joernBench.Odb2Generated.orderSumUnchecked:iTLB-load-misses:u            false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumUnchecked:iTLB-loads:u                  false  avgt         ≈ 10⁻⁵              #/op
joernBench.Odb2Generated.orderSumUnchecked:instructions:u                false  avgt         90.701              #/op
joernBench.Odb2Generated.orderSumUnchecked:·gc.alloc.rate                false  avgt    5     0.004 ±   0.001  MB/sec
joernBench.Odb2Generated.orderSumUnchecked:·gc.alloc.rate.norm           false  avgt    5    ≈ 10⁻⁵              B/op
joernBench.Odb2Generated.orderSumUnchecked:·gc.count                     false  avgt    5       ≈ 0            counts
```

</details>


Feel free to add more benchmarks or prettify the output!

## Odbv1 loading and memory
benchJoern allowed us to discover some inefficiencies in odb1. Before https://github.com/ShiftLeftSecurity/overflowdbv2/pull/11 we saw:

<details>
  <summary>click to see details of old odb1 benchmarks</summary>

```
VM is version 19.0.2+7 with max heap 20480 mb.


SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
Graph with 2387850 nodes (709958 calls) and 20220777 edges at ./cpg.bin

<=========
Running complete benchmark in 17489655192 ns  == 17489.655192 ms == 7.3244362887116035 us/node and costing 1156858400 bytes == 1103.2661437988281 MB == 484.47699813639883 bytes/node.
Top 20 account for 92.34579167165143%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
Object[], 2389516, 425952024, 1.000697698766673,  178.25870343617703, 178.38307431371317
byte[], 3031234, 189729688, 1.26944071026237,  62.59156765858393, 79.45628410494797
overflowdb.AdjacentNodes, 2387850, 57308400, 1.0,  24.0, 24.0
io.shiftleft.codepropertygraph.generated.nodes.Call, 1419916, 56796640, 0.5946420420043135,  40.0, 23.78568168017254
io.shiftleft.codepropertygraph.generated.nodes.CallDb, 709958, 51116976, 0.29732102100215674,  72.0, 21.407113512155288
io.shiftleft.codepropertygraph.generated.nodes.Identifier, 1097266, 43890640, 0.45952048914295285,  40.0, 18.380819565718113
long[], 5, 42029408, 2.0939338735682726E-6,  8405881.6, 17.60136021944427
io.shiftleft.codepropertygraph.generated.nodes.IdentifierDb, 548633, 35112512, 0.22976024457147642,  64.0, 14.704655652574491
Integer, 1799008, 28784128, 0.7534007580040623,  16.0, 12.054412128064996
int[], 452, 21087936, 1.8929162217057186E-4,  46654.72566371682, 8.831348702807965
String, 681085, 16346040, 0.2852293904558494,  24.0, 6.845505370940386
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifier, 401658, 16066320, 0.16820905835793706,  40.0, 6.728362334317482
io.shiftleft.codepropertygraph.generated.nodes.Literal, 358342, 14333680, 0.1500688904244404,  40.0, 6.002755616977616
io.shiftleft.codepropertygraph.generated.nodes.Block, 303730, 12149200, 0.1271981070837783,  40.0, 5.087924283351132
overflowdb.Node[], 1, 11676976, 4.1878677471365454E-7,  1.1676976E7, 4.8901631174487505
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifierDb, 200829, 11246424, 0.08410452917896853,  56.0, 4.709853634022237
io.shiftleft.codepropertygraph.generated.nodes.LiteralDb, 179171, 10033576, 0.0750344452122202,  56.0, 4.201928931884331
java.util.concurrent.ConcurrentHashMap$Node[], 50716, 8842880, 0.021239190066377703,  174.3607540026816, 3.7032811943798816
io.shiftleft.codepropertygraph.generated.nodes.BlockDb, 151865, 8504440, 0.06359905354188915,  56.0, 3.561546998345792
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterIn, 182554, 7302160, 0.07645120087107649,  40.0, 3.05804803484306
=========>



<=========
Running copy and load cpg file in 2965010740 ns  == 2965.0107399999997 ms == 1.2417072847959463 us/node and costing 212889912 bytes == 203.02764129638672 MB == 89.15547961555374 bytes/node.
Top 20 account for 95.25464785762136%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
long[], 13970, 42436376, 0.005850451242749754,  3037.6790264853257, 17.771793035575936
io.shiftleft.codepropertygraph.generated.nodes.Call, 709958, 28398320, 0.29732102100215674,  40.0, 11.89284084008627
io.shiftleft.codepropertygraph.generated.nodes.Identifier, 548633, 21945320, 0.22976024457147642,  40.0, 9.190409782859057
int[], 393, 21020464, 1.6458320246246625E-4,  53487.185750636134, 8.803092321544487
byte[], 81732, 12451800, 0.034228280670896415,  152.34914109528702, 5.214649161379484
Object[], 3951, 12415568, 0.001654626546893649,  3142.3862313338395, 5.199475678958058
overflowdb.Node[], 1, 11676976, 4.1878677471365454E-7,  1.1676976E7, 4.8901631174487505
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifier, 200829, 8033160, 0.08410452917896853,  40.0, 3.364181167158741
io.shiftleft.codepropertygraph.generated.nodes.Literal, 179171, 7166840, 0.0750344452122202,  40.0, 3.001377808488808
io.shiftleft.codepropertygraph.generated.nodes.Block, 151865, 6074600, 0.06359905354188915,  40.0, 2.543962141675566
java.util.concurrent.ConcurrentHashMap$Node[], 50716, 4648704, 0.021239190066377703,  91.66148749901411, 1.9468157547584648
java.util.concurrent.ConcurrentHashMap$Node, 139703, 4470496, 0.05850576878782168,  32.0, 1.8721846012102938
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterIn, 91277, 3651080, 0.03822560043553824,  40.0, 1.52902401742153
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterOut, 91277, 3651080, 0.03822560043553824,  40.0, 1.52902401742153
java.util.concurrent.ConcurrentHashMap, 50718, 3245952, 0.02124002763992713,  64.0, 1.3593617689553363
io.shiftleft.codepropertygraph.generated.nodes.ControlStructure, 80994, 3239760, 0.03391921603115774,  40.0, 1.3567686412463094
io.shiftleft.codepropertygraph.generated.nodes.Local, 56877, 2275080, 0.02381933538538853,  40.0, 0.9527734154155412
io.shiftleft.codepropertygraph.generated.nodes.Method, 55929, 2237160, 0.023422325522959985,  40.0, 0.9368930209183994
io.shiftleft.codepropertygraph.generated.nodes.MethodReturn, 55929, 2237160, 0.023422325522959985,  40.0, 0.9368930209183994
io.shiftleft.codepropertygraph.generated.nodes.Binding, 37791, 1511640, 0.015826371003203717,  40.0, 0.6330548401281487
=========>



<=========
Running load/create indexes in 33230 ns  == 0.033229999999999996 ms == 1.3916284523734743E-5 us/node and costing 88392 bytes == 0.08429718017578125 MB == 0.03701740059048935 bytes/node.
Top 20 account for 100.0%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
byte[], 1035, 64352, 4.334443118286325E-4,  62.17584541062802, 0.026949766526373098
String, 1035, 24840, 4.334443118286325E-4,  24.0, 0.010402663483887178
jdk.internal.ref.CleanerImpl$PhantomCleanableRef, -10, -480, -4.187867747136545E-6,  48.0, -2.0101765186255417E-4
java.lang.invoke.MethodHandleNatives$CallSiteContext, -10, -320, -4.187867747136545E-6,  32.0, -1.3401176790836945E-4
=========>



<=========
Running count edges (force complete loading) in 14156499550 ns  == 14156.499549999999 ms == 5.928554787779802 us/node and costing 969210216 bytes == 924.3108901977539 MB == 405.89242037816445 bytes/node.
Top 20 account for 95.22555754818829%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
Object[], 2389000, 413926328, 1.0004816047909206,  173.2634273754709, 173.34687187218628
byte[], 2992001, 180426632, 1.253010448730029,  60.302998561832034, 75.56028728772745
overflowdb.AdjacentNodes, 2387850, 57308400, 1.0,  24.0, 24.0
io.shiftleft.codepropertygraph.generated.nodes.CallDb, 709958, 51116976, 0.29732102100215674,  72.0, 21.407113512155288
io.shiftleft.codepropertygraph.generated.nodes.IdentifierDb, 548633, 35112512, 0.22976024457147642,  64.0, 14.704655652574491
Integer, 1798992, 28783872, 0.7533940574156668,  16.0, 12.054304918650669
io.shiftleft.codepropertygraph.generated.nodes.Call, 709958, 28398320, 0.29732102100215674,  40.0, 11.89284084008627
io.shiftleft.codepropertygraph.generated.nodes.Identifier, 548633, 21945320, 0.22976024457147642,  40.0, 9.190409782859057
java.util.concurrent.ConcurrentHashMap$Node, 622977, 19935264, 0.2608945285507884,  32.0, 8.348624913625228
String, 623331, 14959944, 0.261042779069037,  24.0, 6.265026697656888
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifierDb, 200829, 11246424, 0.08410452917896853,  56.0, 4.709853634022237
io.shiftleft.codepropertygraph.generated.nodes.LiteralDb, 179171, 10033576, 0.0750344452122202,  56.0, 4.201928931884331
io.shiftleft.codepropertygraph.generated.nodes.BlockDb, 151865, 8504440, 0.06359905354188915,  56.0, 3.561546998345792
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifier, 200829, 8033160, 0.08410452917896853,  40.0, 3.364181167158741
io.shiftleft.codepropertygraph.generated.nodes.Literal, 179171, 7166840, 0.0750344452122202,  40.0, 3.001377808488808
io.shiftleft.codepropertygraph.generated.nodes.Block, 151865, 6074600, 0.06359905354188915,  40.0, 2.543962141675566
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterInDb, 91277, 5841728, 0.03822560043553824,  64.0, 2.4464384278744475
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterOutDb, 91277, 5111512, 0.03822560043553824,  56.0, 2.1406336243901416
io.shiftleft.codepropertygraph.generated.nodes.ControlStructureDb, 80994, 4535664, 0.03391921603115774,  56.0, 1.8994760977448333
io.shiftleft.codepropertygraph.generated.nodes.MethodDb, 55929, 4474320, 0.023422325522959985,  80.0, 1.8737860418367989
=========>



<=========
Running count edges again in 368101711 ns  == 368.10171099999997 ms == 0.15415612831626777 us/node and costing 95904 bytes == 0.091461181640625 MB == 0.040163326842138324 bytes/node.
Top 20 account for 100.0%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
byte[], 1102, 69520, 4.6150302573444733E-4,  63.08529945553539, 0.029114056578093263
String, 1102, 26448, 4.6150302573444733E-4,  24.0, 0.011076072617626736
jdk.internal.ref.CleanerImpl$PhantomCleanableRef, -1, -48, -4.1878677471365454E-7,  48.0, -2.010176518625542E-5
java.lang.invoke.MethodHandleNatives$CallSiteContext, -1, -32, -4.1878677471365454E-7,  32.0, -1.3401176790836945E-5
Integer, 1, 16, 4.1878677471365454E-7,  16.0, 6.700588395418473E-6
=========>



<=========
Running close graph in 368532341 ns  == 368.532341 ms == 0.15433647046506271 us/node and costing -25223528 bytes == -24.055030822753906 MB == -10.563279938019557 bytes/node.
Top 20 account for 99.76764550938314%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
java.util.concurrent.ConcurrentHashMap$Node, -622940, -19934080, -0.260879033440124,  32.0, -8.348129070083967
byte[], -41558, -3084872, -0.017403940783550054,  74.23052119928774, -1.2919035952844609
Long, -44511, -1068264, -0.018640618129279477,  24.0, -0.4473748351027075
org.h2.mvstore.cache.CacheLongKeyLIRS$Entry, -8019, -449064, -0.0033582511464287958,  56.0, -0.18806206420001256
Object[], -3613, -395816, -0.0015130766170404339,  109.55327982286188, -0.16576250602005987
java.lang.ref.WeakReference, -6166, -197312, -0.002582239252884394,  32.0, -0.08263165609230061
org.h2.mvstore.Page$Leaf, -1780, -85440, -7.454404589903051E-4,  48.0, -0.035781142031534645
int[], 4, 65600, 1.6751470988546182E-6,  16400.0, 0.027472412421215738
org.h2.mvstore.Page$PageReference, -1875, -60000, -7.852252025881023E-4,  32.0, -0.025127206482819273
java.nio.ByteBuffer[], 11, 45232, 4.6066545218502E-6,  4112.0, 0.018942563393848023
String, 1181, 28344, 4.945871809368261E-4,  24.0, 0.011870092342483825
org.h2.mvstore.Chunk, -232, -25984, -9.715853173356786E-5,  112.0, -0.0108817555541596
org.h2.mvstore.Page$PageReference[], -68, -8680, -2.847750068052851E-5,  127.6470588235294, -0.0036350692045145215
Class, 56, 6352, 2.3452059383964653E-5,  113.42857142857143, 0.0026601335929811337
org.h2.mvstore.Page$NonLeaf, -68, -3808, -2.847750068052851E-5,  56.0, -0.0015947400381095965
Integer, -216, -3456, -9.045794333814938E-5,  16.0, -0.00144732709341039
org.h2.mvstore.MVStore$RemovedPageInfo, 103, 2472, 4.3135037795506416E-5,  24.0, 0.001035240907092154
java.lang.invoke.MethodType$ConcurrentWeakInternSet$WeakEntry, 68, 2176, 2.847750068052851E-5,  32.0, 9.112800217769123E-4
jdk.internal.ref.CleanerImpl$PhantomCleanableRef, 35, 1680, 1.4657537114977908E-5,  48.0, 7.035617815189396E-4
=========>



<=========
Running free memory in 9961 ns  == 0.009961 ms == 4.171535062922713E-6 us/node and costing -1155444832 bytes == -1101.9180603027344 MB == -483.8850145528404 bytes/node.
Top 20 account for 92.39256037453114%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
Object[], -2388659, -425891760, -1.0003387985007433,  178.29742964567149, -178.35783654752183
byte[], -3022523, -189265712, -1.2657926586678392,  62.618452200363734, -79.26197709236342
overflowdb.AdjacentNodes, -2387850, -57308400, -1.0,  24.0, -24.0
io.shiftleft.codepropertygraph.generated.nodes.Call, -1419916, -56796640, -0.5946420420043135,  40.0, -23.78568168017254
io.shiftleft.codepropertygraph.generated.nodes.CallDb, -709958, -51116976, -0.29732102100215674,  72.0, -21.407113512155288
io.shiftleft.codepropertygraph.generated.nodes.Identifier, -1097266, -43890640, -0.45952048914295285,  40.0, -18.380819565718113
long[], -3, -42029376, -1.2563603241409637E-6,  1.4009792E7, -17.60134681826748
io.shiftleft.codepropertygraph.generated.nodes.IdentifierDb, -548633, -35112512, -0.22976024457147642,  64.0, -14.704655652574491
Integer, -1798992, -28783872, -0.7533940574156668,  16.0, -12.054304918650669
int[], -11, -21072552, -4.6066545218502E-6,  1915686.5454545454, -8.82490608706577
String, -672391, -16137384, -0.28158845823648887,  24.0, -6.758122997675733
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifier, -401658, -16066320, -0.16820905835793706,  40.0, -6.728362334317482
io.shiftleft.codepropertygraph.generated.nodes.Literal, -358342, -14333680, -0.1500688904244404,  40.0, -6.002755616977616
io.shiftleft.codepropertygraph.generated.nodes.Block, -303730, -12149200, -0.1271981070837783,  40.0, -5.087924283351132
overflowdb.Node[], -1, -11676976, -4.1878677471365454E-7,  1.1676976E7, -4.8901631174487505
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifierDb, -200829, -11246424, -0.08410452917896853,  56.0, -4.709853634022237
io.shiftleft.codepropertygraph.generated.nodes.LiteralDb, -179171, -10033576, -0.0750344452122202,  56.0, -4.201928931884331
java.util.concurrent.ConcurrentHashMap$Node[], -50682, -8826464, -0.021224951316037438,  174.15382186969734, -3.696406390686182
io.shiftleft.codepropertygraph.generated.nodes.BlockDb, -151865, -8504440, -0.06359905354188915,  56.0, -3.561546998345792
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterIn, -182554, -7302160, -0.07645120087107649,  40.0, -3.05804803484306
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


overflowdb.AdjacentNodes object internals:
OFF  SZ                 TYPE DESCRIPTION                             VALUE
  0   8                      (object header: mark)                   N/A
  8   4                      (object header: class)                  N/A
 12   4   java.lang.Object[] AdjacentNodes.nodesWithEdgeProperties   N/A
 16   4     java.lang.Object AdjacentNodes.offsets                   N/A
 20   4                      (object alignment gap)                  
Instance size: 24 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.Call object internals:
OFF  SZ                TYPE DESCRIPTION               VALUE
  0   8                     (object header: mark)     N/A
  8   4                     (object header: class)    N/A
 12   4    overflowdb.Graph NodeRef.graph             N/A
 16   8                long NodeRef.id                N/A
 24   4   overflowdb.NodeDb NodeRef.node              N/A
 28   4                     (alignment/padding gap)   
 32   8                long Call.id                   N/A
Instance size: 40 bytes
Space losses: 4 bytes internal + 0 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.CallDb object internals:
OFF  SZ                                    TYPE DESCRIPTION                       VALUE
  0   8                                         (object header: mark)             N/A
  8   4                                         (object header: class)            N/A
 12   1                                 boolean NodeDb.dirty                      N/A
 13   3                                         (alignment/padding gap)           
 16   4                      overflowdb.NodeRef NodeDb.ref                        N/A
 20   4                overflowdb.AdjacentNodes NodeDb.adjacentNodes              N/A
 24   4                                     int CallDb._argumentIndex             N/A
 28   4                                     int CallDb._order                     N/A
 32   4                        java.lang.String CallDb._argumentName              N/A
 36   4                        java.lang.String CallDb._code                      N/A
 40   4                       java.lang.Integer CallDb._columnNumber              N/A
 44   4                        java.lang.String CallDb._dispatchType              N/A
 48   4   scala.collection.immutable.IndexedSeq CallDb._dynamicTypeHintFullName   N/A
 52   4                       java.lang.Integer CallDb._lineNumber                N/A
 56   4                        java.lang.String CallDb._methodFullName            N/A
 60   4                        java.lang.String CallDb._name                      N/A
 64   4                        java.lang.String CallDb._signature                 N/A
 68   4                        java.lang.String CallDb._typeFullName              N/A
Instance size: 72 bytes
Space losses: 3 bytes internal + 0 bytes external = 3 bytes total


io.shiftleft.codepropertygraph.generated.nodes.Identifier object internals:
OFF  SZ                TYPE DESCRIPTION               VALUE
  0   8                     (object header: mark)     N/A
  8   4                     (object header: class)    N/A
 12   4    overflowdb.Graph NodeRef.graph             N/A
 16   8                long NodeRef.id                N/A
 24   4   overflowdb.NodeDb NodeRef.node              N/A
 28   4                     (alignment/padding gap)   
 32   8                long Identifier.id             N/A
Instance size: 40 bytes
Space losses: 4 bytes internal + 0 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.IdentifierDb object internals:
OFF  SZ                                    TYPE DESCRIPTION                             VALUE
  0   8                                         (object header: mark)                   N/A
  8   4                                         (object header: class)                  N/A
 12   1                                 boolean NodeDb.dirty                            N/A
 13   3                                         (alignment/padding gap)                 
 16   4                      overflowdb.NodeRef NodeDb.ref                              N/A
 20   4                overflowdb.AdjacentNodes NodeDb.adjacentNodes                    N/A
 24   4                                     int IdentifierDb._argumentIndex             N/A
 28   4                                     int IdentifierDb._order                     N/A
 32   4                        java.lang.String IdentifierDb._argumentName              N/A
 36   4                        java.lang.String IdentifierDb._code                      N/A
 40   4                       java.lang.Integer IdentifierDb._columnNumber              N/A
 44   4   scala.collection.immutable.IndexedSeq IdentifierDb._dynamicTypeHintFullName   N/A
 48   4                       java.lang.Integer IdentifierDb._lineNumber                N/A
 52   4                        java.lang.String IdentifierDb._name                      N/A
 56   4                        java.lang.String IdentifierDb._typeFullName              N/A
 60   4                                         (object alignment gap)                  
Instance size: 64 bytes
Space losses: 3 bytes internal + 4 bytes external = 7 bytes total


io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifier object internals:
OFF  SZ                TYPE DESCRIPTION               VALUE
  0   8                     (object header: mark)     N/A
  8   4                     (object header: class)    N/A
 12   4    overflowdb.Graph NodeRef.graph             N/A
 16   8                long NodeRef.id                N/A
 24   4   overflowdb.NodeDb NodeRef.node              N/A
 28   4                     (alignment/padding gap)   
 32   8                long FieldIdentifier.id        N/A
Instance size: 40 bytes
Space losses: 4 bytes internal + 0 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.Literal object internals:
OFF  SZ                TYPE DESCRIPTION               VALUE
  0   8                     (object header: mark)     N/A
  8   4                     (object header: class)    N/A
 12   4    overflowdb.Graph NodeRef.graph             N/A
 16   8                long NodeRef.id                N/A
 24   4   overflowdb.NodeDb NodeRef.node              N/A
 28   4                     (alignment/padding gap)   
 32   8                long Literal.id                N/A
Instance size: 40 bytes
Space losses: 4 bytes internal + 0 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.Block object internals:
OFF  SZ                TYPE DESCRIPTION               VALUE
  0   8                     (object header: mark)     N/A
  8   4                     (object header: class)    N/A
 12   4    overflowdb.Graph NodeRef.graph             N/A
 16   8                long NodeRef.id                N/A
 24   4   overflowdb.NodeDb NodeRef.node              N/A
 28   4                     (alignment/padding gap)   
 32   8                long Block.id                  N/A
Instance size: 40 bytes
Space losses: 4 bytes internal + 0 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifierDb object internals:
OFF  SZ                       TYPE DESCRIPTION                        VALUE
  0   8                            (object header: mark)              N/A
  8   4                            (object header: class)             N/A
 12   1                    boolean NodeDb.dirty                       N/A
 13   3                            (alignment/padding gap)            
 16   4         overflowdb.NodeRef NodeDb.ref                         N/A
 20   4   overflowdb.AdjacentNodes NodeDb.adjacentNodes               N/A
 24   4                        int FieldIdentifierDb._argumentIndex   N/A
 28   4                        int FieldIdentifierDb._order           N/A
 32   4           java.lang.String FieldIdentifierDb._argumentName    N/A
 36   4           java.lang.String FieldIdentifierDb._canonicalName   N/A
 40   4           java.lang.String FieldIdentifierDb._code            N/A
 44   4          java.lang.Integer FieldIdentifierDb._columnNumber    N/A
 48   4          java.lang.Integer FieldIdentifierDb._lineNumber      N/A
 52   4                            (object alignment gap)             
Instance size: 56 bytes
Space losses: 3 bytes internal + 4 bytes external = 7 bytes total


io.shiftleft.codepropertygraph.generated.nodes.LiteralDb object internals:
OFF  SZ                                    TYPE DESCRIPTION                          VALUE
  0   8                                         (object header: mark)                N/A
  8   4                                         (object header: class)               N/A
 12   1                                 boolean NodeDb.dirty                         N/A
 13   3                                         (alignment/padding gap)              
 16   4                      overflowdb.NodeRef NodeDb.ref                           N/A
 20   4                overflowdb.AdjacentNodes NodeDb.adjacentNodes                 N/A
 24   4                                     int LiteralDb._argumentIndex             N/A
 28   4                                     int LiteralDb._order                     N/A
 32   4                        java.lang.String LiteralDb._argumentName              N/A
 36   4                        java.lang.String LiteralDb._code                      N/A
 40   4                       java.lang.Integer LiteralDb._columnNumber              N/A
 44   4   scala.collection.immutable.IndexedSeq LiteralDb._dynamicTypeHintFullName   N/A
 48   4                       java.lang.Integer LiteralDb._lineNumber                N/A
 52   4                        java.lang.String LiteralDb._typeFullName              N/A
Instance size: 56 bytes
Space losses: 3 bytes internal + 0 bytes external = 3 bytes total


io.shiftleft.codepropertygraph.generated.nodes.BlockDb object internals:
OFF  SZ                                    TYPE DESCRIPTION                        VALUE
  0   8                                         (object header: mark)              N/A
  8   4                                         (object header: class)             N/A
 12   1                                 boolean NodeDb.dirty                       N/A
 13   3                                         (alignment/padding gap)            
 16   4                      overflowdb.NodeRef NodeDb.ref                         N/A
 20   4                overflowdb.AdjacentNodes NodeDb.adjacentNodes               N/A
 24   4                                     int BlockDb._argumentIndex             N/A
 28   4                                     int BlockDb._order                     N/A
 32   4                        java.lang.String BlockDb._argumentName              N/A
 36   4                        java.lang.String BlockDb._code                      N/A
 40   4                       java.lang.Integer BlockDb._columnNumber              N/A
 44   4   scala.collection.immutable.IndexedSeq BlockDb._dynamicTypeHintFullName   N/A
 48   4                       java.lang.Integer BlockDb._lineNumber                N/A
 52   4                        java.lang.String BlockDb._typeFullName              N/A
Instance size: 56 bytes
Space losses: 3 bytes internal + 0 bytes external = 3 bytes total


io.shiftleft.codepropertygraph.generated.nodes.MethodParameterIn object internals:
OFF  SZ                TYPE DESCRIPTION               VALUE
  0   8                     (object header: mark)     N/A
  8   4                     (object header: class)    N/A
 12   4    overflowdb.Graph NodeRef.graph             N/A
 16   8                long NodeRef.id                N/A
 24   4   overflowdb.NodeDb NodeRef.node              N/A
 28   4                     (alignment/padding gap)   
 32   8                long MethodParameterIn.id      N/A
Instance size: 40 bytes
Space losses: 4 bytes internal + 0 bytes external = 4 bytes total
```

</details>

After merging the improvements upstream (https://github.com/ShiftLeftSecurity/overflowdbv2/pull/13) we obtain a 10% reduction of heap memory usage:

<details>
  <summary>click to see details of new odb1 benchmarks</summary>

```
VM is version 19.0.2+7 with max heap 20480 mb.


[main] INFO overflowdb.Graph - initializing 2387850 nodes from existing storage
[main] INFO overflowdb.HeapUsageMonitor - installed GC monitors. will clear references if heap (after GC) is larger than 80%
[main] INFO overflowdb.Graph - shutdown: start
[main] INFO overflowdb.storage.NodesWriter - serializing and persisting 2387850 nodes (this may take a while)
[main] INFO overflowdb.storage.NodesWriter - finished serializing and persisting 2387850 nodes
[main] INFO overflowdb.Graph - shutdown finished
Graph with 2387850 nodes (709958 calls) and 20220777 edges at ./cpg.bin.
On disk 294252544 bytes = 123.22907385304772 bytes/node.
Loading data from disk at 61.01362233252264 ns/byte and filling the heap at 17.225882177043133 ns/byte.

<=========
Running complete benchmark in 17953413590 ns  == 17953.41359 ms == 7.5186521724563935 us/node and costing 1042234784 bytes == 993.9525451660156 MB == 436.4741436857424 bytes/node.
Top 20 account for 94.14840101901646%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
Object[], 2389531, 425952712, 1.0007039805682936,  178.25787236072685, 178.38336243901418
byte[], 3033497, 189814472, 1.2703884247335469,  62.5728233784309, 79.49179052285528
overflowdb.AdjacentNodes, 2387850, 57308400, 1.0,  24.0, 24.0
io.shiftleft.codepropertygraph.generated.nodes.CallDb, 709958, 51116976, 0.29732102100215674,  72.0, 21.407113512155288
long[], 5, 42029408, 2.0939338735682726E-6,  8405881.6, 17.60136021944427
io.shiftleft.codepropertygraph.generated.nodes.IdentifierDb, 548633, 35112512, 0.22976024457147642,  64.0, 14.704655652574491
Integer, 1799008, 28784128, 0.7534007580040623,  16.0, 12.054412128064996
io.shiftleft.codepropertygraph.generated.nodes.Call, 709958, 22718656, 0.29732102100215674,  32.0, 9.514272672069016
int[], 458, 21088296, 1.9180434281885377E-4,  46044.31441048035, 8.831499466046862
io.shiftleft.codepropertygraph.generated.nodes.Identifier, 548633, 17556256, 0.22976024457147642,  32.0, 7.352327826287246
String, 681158, 16347792, 0.2852599618904035,  24.0, 6.846239085369684
overflowdb.Node[], 1, 11676976, 4.1878677471365454E-7,  1.1676976E7, 4.8901631174487505
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifierDb, 200829, 11246424, 0.08410452917896853,  56.0, 4.709853634022237
io.shiftleft.codepropertygraph.generated.nodes.LiteralDb, 179171, 10033576, 0.0750344452122202,  56.0, 4.201928931884331
java.util.concurrent.ConcurrentHashMap$Node[], 50719, 8843120, 0.021240446426701844,  174.35517261775666, 3.703381703205813
io.shiftleft.codepropertygraph.generated.nodes.BlockDb, 151865, 8504440, 0.06359905354188915,  56.0, 3.561546998345792
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifier, 200829, 6426528, 0.08410452917896853,  32.0, 2.691344933726993
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterInDb, 91277, 5841728, 0.03822560043553824,  64.0, 2.4464384278744475
io.shiftleft.codepropertygraph.generated.nodes.Literal, 179171, 5733472, 0.0750344452122202,  32.0, 2.4011022467910466
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterOutDb, 91277, 5111512, 0.03822560043553824,  56.0, 2.1406336243901416
=========>



<=========
Running copy and load cpg file in 3031893062 ns  == 3031.8930619999996 ms == 1.2697167167116863 us/node and costing 193806496 bytes == 184.82827758789062 MB == 81.16359737839478 bytes/node.
Top 20 account for 95.39694685982043%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
long[], 13970, 42436376, 0.005850451242749754,  3037.6790264853257, 17.771793035575936
io.shiftleft.codepropertygraph.generated.nodes.Call, 709958, 22718656, 0.29732102100215674,  32.0, 9.514272672069016
int[], 397, 21020552, 1.6625834956132085E-4,  52948.49370277078, 8.803129174780661
io.shiftleft.codepropertygraph.generated.nodes.Identifier, 548633, 17556256, 0.22976024457147642,  32.0, 7.352327826287246
byte[], 81834, 12457696, 0.03427099692191721,  152.23129750470466, 5.217118328203195
Object[], 3966, 12416256, 0.0016609083485143539,  3130.674735249622, 5.199763804259062
overflowdb.Node[], 1, 11676976, 4.1878677471365454E-7,  1.1676976E7, 4.8901631174487505
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifier, 200829, 6426528, 0.08410452917896853,  32.0, 2.691344933726993
io.shiftleft.codepropertygraph.generated.nodes.Literal, 179171, 5733472, 0.0750344452122202,  32.0, 2.4011022467910466
io.shiftleft.codepropertygraph.generated.nodes.Block, 151865, 4859680, 0.06359905354188915,  32.0, 2.0351697133404527
java.util.concurrent.ConcurrentHashMap$Node[], 50719, 4648944, 0.021240446426701844,  91.66079772866185, 1.946916263584396
java.util.concurrent.ConcurrentHashMap$Node, 139745, 4471840, 0.05852335783235965,  32.0, 1.8727474506355088
java.util.concurrent.ConcurrentHashMap, 50724, 3246336, 0.021242540360575414,  64.0, 1.3595225830768265
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterIn, 91277, 2920864, 0.03822560043553824,  32.0, 1.2232192139372238
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterOut, 91277, 2920864, 0.03822560043553824,  32.0, 1.2232192139372238
io.shiftleft.codepropertygraph.generated.nodes.ControlStructure, 80994, 2591808, 0.03391921603115774,  32.0, 1.0854149129970476
io.shiftleft.codepropertygraph.generated.nodes.Local, 56877, 1820064, 0.02381933538538853,  32.0, 0.762218732332433
io.shiftleft.codepropertygraph.generated.nodes.Method, 55929, 1789728, 0.023422325522959985,  32.0, 0.7495144167347195
io.shiftleft.codepropertygraph.generated.nodes.MethodReturn, 55929, 1789728, 0.023422325522959985,  32.0, 0.7495144167347195
String, 57619, 1382856, 0.02413007517222606,  24.0, 0.5791218041334255
=========>



<=========
Running load/create indexes in 39038 ns  == 0.039037999999999996 ms == 1.6348598111271648E-5 us/node and costing 89352 bytes == 0.08521270751953125 MB == 0.03741943589421446 bytes/node.
Top 20 account for 100.0%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
byte[], 1047, 65024, 4.384697531251963E-4,  62.10506208213945, 0.027231191238980674
String, 1047, 25128, 4.384697531251963E-4,  24.0, 0.010523274075004712
jdk.internal.ref.CleanerImpl$PhantomCleanableRef, -10, -480, -4.187867747136545E-6,  48.0, -2.0101765186255417E-4
java.lang.invoke.MethodHandleNatives$CallSiteContext, -10, -320, -4.187867747136545E-6,  32.0, -1.3401176790836945E-4
=========>



<=========
Running count edges (force complete loading) in 14586411546 ns  == 14586.411546 ms == 6.108596245995352 us/node and costing 873648352 bytes == 833.1759948730469 MB == 365.8723755679796 bytes/node.
Top 20 account for 98.75642505647399%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
Object[], 2389000, 413926328, 1.0004816047909206,  173.2634273754709, 173.34687187218628
byte[], 2994203, 180507832, 1.2539326172079486,  60.28576953533211, 75.5942927738342
overflowdb.AdjacentNodes, 2387850, 57308400, 1.0,  24.0, 24.0
io.shiftleft.codepropertygraph.generated.nodes.CallDb, 709958, 51116976, 0.29732102100215674,  72.0, 21.407113512155288
io.shiftleft.codepropertygraph.generated.nodes.IdentifierDb, 548633, 35112512, 0.22976024457147642,  64.0, 14.704655652574491
Integer, 1798992, 28783872, 0.7533940574156668,  16.0, 12.054304918650669
java.util.concurrent.ConcurrentHashMap$Node, 622977, 19935264, 0.2608945285507884,  32.0, 8.348624913625228
String, 623344, 14960256, 0.26104822329710825,  24.0, 6.2651573591305985
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifierDb, 200829, 11246424, 0.08410452917896853,  56.0, 4.709853634022237
io.shiftleft.codepropertygraph.generated.nodes.LiteralDb, 179171, 10033576, 0.0750344452122202,  56.0, 4.201928931884331
io.shiftleft.codepropertygraph.generated.nodes.BlockDb, 151865, 8504440, 0.06359905354188915,  56.0, 3.561546998345792
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterInDb, 91277, 5841728, 0.03822560043553824,  64.0, 2.4464384278744475
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterOutDb, 91277, 5111512, 0.03822560043553824,  56.0, 2.1406336243901416
io.shiftleft.codepropertygraph.generated.nodes.ControlStructureDb, 80994, 4535664, 0.03391921603115774,  56.0, 1.8994760977448333
io.shiftleft.codepropertygraph.generated.nodes.MethodDb, 55929, 4474320, 0.023422325522959985,  80.0, 1.8737860418367989
short[], 35518, 3468504, 0.014874468664279583,  97.6548229066952, 1.4525636032414095
io.shiftleft.codepropertygraph.generated.nodes.LocalDb, 56877, 3185112, 0.02381933538538853,  56.0, 1.3338827815817575
io.shiftleft.codepropertygraph.generated.nodes.MethodReturnDb, 55929, 3132024, 0.023422325522959985,  56.0, 1.3116502292857593
io.shiftleft.codepropertygraph.generated.nodes.MemberDb, 28556, 1599136, 0.011958875138723119,  56.0, 0.6696970077684947
=========>



<=========
Running count edges again in 335069944 ns  == 335.06994399999996 ms == 0.14032286115124484 us/node and costing 96864 bytes == 0.092376708984375 MB == 0.04056536214586343 bytes/node.
Top 20 account for 100.0%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
byte[], 1114, 70192, 4.6652846703101116E-4,  63.00897666068223, 0.02939548129070084
String, 1114, 26736, 4.6652846703101116E-4,  24.0, 0.011196683208744267
jdk.internal.ref.CleanerImpl$PhantomCleanableRef, -1, -48, -4.1878677471365454E-7,  48.0, -2.010176518625542E-5
java.lang.invoke.MethodHandleNatives$CallSiteContext, -1, -32, -4.1878677471365454E-7,  32.0, -1.3401176790836945E-5
Integer, 1, 16, 4.1878677471365454E-7,  16.0, 6.700588395418473E-6
=========>



<=========
Running close graph in 366691356 ns  == 366.691356 ms == 0.1535654902946165 us/node and costing -25196864 bytes == -24.02960205078125 MB == -10.552113407458592 bytes/node.
Top 20 account for 99.76981262430118%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
java.util.concurrent.ConcurrentHashMap$Node, -622941, -19934112, -0.2608794522268987,  32.0, -8.348142471260758
byte[], -41536, -3083808, -0.017394727474506357,  74.2442218798151, -1.2914580061561656
Long, -44511, -1068264, -0.018640618129279477,  24.0, -0.4473748351027075
org.h2.mvstore.cache.CacheLongKeyLIRS$Entry, -7742, -433552, -0.0032422472098331133,  56.0, -0.18156584375065435
Object[], -3613, -395816, -0.0015130766170404339,  109.55327982286188, -0.16576250602005987
java.lang.ref.WeakReference, -5889, -188448, -0.0024662353162887116,  32.0, -0.07891953012123877
org.h2.mvstore.Page$Leaf, -1780, -85440, -7.454404589903051E-4,  48.0, -0.035781142031534645
int[], 4, 65600, 1.6751470988546182E-6,  16400.0, 0.027472412421215738
org.h2.mvstore.Page$PageReference, -1875, -60000, -7.852252025881023E-4,  32.0, -0.025127206482819273
java.nio.ByteBuffer[], 11, 45232, 4.6066545218502E-6,  4112.0, 0.018942563393848023
String, 1203, 28872, 5.038004899805264E-4,  24.0, 0.012091211759532634
org.h2.mvstore.Chunk, -232, -25984, -9.715853173356786E-5,  112.0, -0.0108817555541596
org.h2.mvstore.Page$PageReference[], -68, -8680, -2.847750068052851E-5,  127.6470588235294, -0.0036350692045145215
Class, 56, 6352, 2.3452059383964653E-5,  113.42857142857143, 0.0026601335929811337
org.h2.mvstore.Page$NonLeaf, -68, -3808, -2.847750068052851E-5,  56.0, -0.0015947400381095965
Integer, -216, -3456, -9.045794333814938E-5,  16.0, -0.00144732709341039
org.h2.mvstore.MVStore$RemovedPageInfo, 108, 2592, 4.522897166907469E-5,  24.0, 0.0010854953200577927
java.lang.invoke.MethodType$ConcurrentWeakInternSet$WeakEntry, 68, 2176, 2.847750068052851E-5,  32.0, 9.112800217769123E-4
jdk.internal.ref.CleanerImpl$PhantomCleanableRef, 35, 1680, 1.4657537114977908E-5,  48.0, 7.035617815189396E-4
=========>



<=========
Running free memory in 8209 ns  == 0.008209 ms == 3.43782063362439E-6 us/node and costing -1040803712 bytes == -992.5877685546875 MB == -435.87482965847937 bytes/node.
Top 20 account for 94.20368093383587%:
Class, #instances, total size, instances/node, bytes/instance, bytes/node
Object[], -2388659, -425891760, -1.0003387985007433,  178.29742964567149, -178.35783654752183
byte[], -3024699, -189346584, -1.2667039386896162,  62.60014103882733, -79.29584521640807
overflowdb.AdjacentNodes, -2387850, -57308400, -1.0,  24.0, -24.0
io.shiftleft.codepropertygraph.generated.nodes.CallDb, -709958, -51116976, -0.29732102100215674,  72.0, -21.407113512155288
long[], -3, -42029376, -1.2563603241409637E-6,  1.4009792E7, -17.60134681826748
io.shiftleft.codepropertygraph.generated.nodes.IdentifierDb, -548633, -35112512, -0.22976024457147642,  64.0, -14.704655652574491
Integer, -1798992, -28783872, -0.7533940574156668,  16.0, -12.054304918650669
io.shiftleft.codepropertygraph.generated.nodes.Call, -709958, -22718656, -0.29732102100215674,  32.0, -9.514272672069016
int[], -13, -21072824, -5.444228071277509E-6,  1620986.4615384615, -8.825019997068493
io.shiftleft.codepropertygraph.generated.nodes.Identifier, -548633, -17556256, -0.22976024457147642,  32.0, -7.352327826287246
String, -672378, -16137072, -0.2815830140084176,  24.0, -6.757992336202022
overflowdb.Node[], -1, -11676976, -4.1878677471365454E-7,  1.1676976E7, -4.8901631174487505
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifierDb, -200829, -11246424, -0.08410452917896853,  56.0, -4.709853634022237
io.shiftleft.codepropertygraph.generated.nodes.LiteralDb, -179171, -10033576, -0.0750344452122202,  56.0, -4.201928931884331
java.util.concurrent.ConcurrentHashMap$Node[], -50682, -8826464, -0.021224951316037438,  174.15382186969734, -3.696406390686182
io.shiftleft.codepropertygraph.generated.nodes.BlockDb, -151865, -8504440, -0.06359905354188915,  56.0, -3.561546998345792
io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifier, -200829, -6426528, -0.08410452917896853,  32.0, -2.691344933726993
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterInDb, -91277, -5841728, -0.03822560043553824,  64.0, -2.4464384278744475
io.shiftleft.codepropertygraph.generated.nodes.Literal, -179171, -5733472, -0.0750344452122202,  32.0, -2.4011022467910466
io.shiftleft.codepropertygraph.generated.nodes.MethodParameterOutDb, -91277, -5111512, -0.03822560043553824,  56.0, -2.1406336243901416
=========>


# WARNING: Unable to attach Serviceability Agent. You can try again with escalated privileges. Two options: a) use -Djol.tryWithSudo=true to try with sudo; b) echo 0 | sudo tee /proc/sys/kernel/yama/ptrace_scope
VM details according to JOL: # VM mode: 64 bits
# Compressed references (oops): 3-bit shift
# Compressed class pointers: 3-bit shift
# WARNING | Compressed references base/shifts are guessed by the experiment!
# WARNING | Therefore, computed addresses are just guesses, and ARE NOT RELIABLE.
# WARNING | Make sure to attach Serviceability Agent to get the reliable addresses.
# Object alignment: 8 bytes
#                       ref, bool, byte, char, shrt,  int,  flt,  lng,  dbl
# Field sizes:            4,    1,    1,    2,    2,    4,    4,    8,    8
# Array element sizes:    4,    1,    1,    2,    2,    4,    4,    8,    8
# Array base offsets:    16,   16,   16,   16,   16,   16,   16,   16,   16
. Layout of top consumers: 


overflowdb.AdjacentNodes object internals:
OFF  SZ                 TYPE DESCRIPTION                             VALUE
  0   8                      (object header: mark)                   N/A
  8   4                      (object header: class)                  N/A
 12   4   java.lang.Object[] AdjacentNodes.nodesWithEdgeProperties   N/A
 16   4     java.lang.Object AdjacentNodes.offsets                   N/A
 20   4                      (object alignment gap)                  
Instance size: 24 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.CallDb object internals:
OFF  SZ                                    TYPE DESCRIPTION                       VALUE
  0   8                                         (object header: mark)             N/A
  8   4                                         (object header: class)            N/A
 12   1                                 boolean NodeDb.dirty                      N/A
 13   3                                         (alignment/padding gap)           
 16   4                      overflowdb.NodeRef NodeDb.ref                        N/A
 20   4                overflowdb.AdjacentNodes NodeDb.adjacentNodes              N/A
 24   4                                     int CallDb._argumentIndex             N/A
 28   4                                     int CallDb._order                     N/A
 32   4                        java.lang.String CallDb._argumentName              N/A
 36   4                        java.lang.String CallDb._code                      N/A
 40   4                       java.lang.Integer CallDb._columnNumber              N/A
 44   4                        java.lang.String CallDb._dispatchType              N/A
 48   4   scala.collection.immutable.IndexedSeq CallDb._dynamicTypeHintFullName   N/A
 52   4                       java.lang.Integer CallDb._lineNumber                N/A
 56   4                        java.lang.String CallDb._methodFullName            N/A
 60   4                        java.lang.String CallDb._name                      N/A
 64   4                        java.lang.String CallDb._signature                 N/A
 68   4                        java.lang.String CallDb._typeFullName              N/A
Instance size: 72 bytes
Space losses: 3 bytes internal + 0 bytes external = 3 bytes total


io.shiftleft.codepropertygraph.generated.nodes.IdentifierDb object internals:
OFF  SZ                                    TYPE DESCRIPTION                             VALUE
  0   8                                         (object header: mark)                   N/A
  8   4                                         (object header: class)                  N/A
 12   1                                 boolean NodeDb.dirty                            N/A
 13   3                                         (alignment/padding gap)                 
 16   4                      overflowdb.NodeRef NodeDb.ref                              N/A
 20   4                overflowdb.AdjacentNodes NodeDb.adjacentNodes                    N/A
 24   4                                     int IdentifierDb._argumentIndex             N/A
 28   4                                     int IdentifierDb._order                     N/A
 32   4                        java.lang.String IdentifierDb._argumentName              N/A
 36   4                        java.lang.String IdentifierDb._code                      N/A
 40   4                       java.lang.Integer IdentifierDb._columnNumber              N/A
 44   4   scala.collection.immutable.IndexedSeq IdentifierDb._dynamicTypeHintFullName   N/A
 48   4                       java.lang.Integer IdentifierDb._lineNumber                N/A
 52   4                        java.lang.String IdentifierDb._name                      N/A
 56   4                        java.lang.String IdentifierDb._typeFullName              N/A
 60   4                                         (object alignment gap)                  
Instance size: 64 bytes
Space losses: 3 bytes internal + 4 bytes external = 7 bytes total


io.shiftleft.codepropertygraph.generated.nodes.Call object internals:
OFF  SZ                TYPE DESCRIPTION               VALUE
  0   8                     (object header: mark)     N/A
  8   4                     (object header: class)    N/A
 12   4    overflowdb.Graph NodeRef.graph             N/A
 16   8                long NodeRef.id                N/A
 24   4   overflowdb.NodeDb NodeRef.node              N/A
 28   4                     (object alignment gap)    
Instance size: 32 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.Identifier object internals:
OFF  SZ                TYPE DESCRIPTION               VALUE
  0   8                     (object header: mark)     N/A
  8   4                     (object header: class)    N/A
 12   4    overflowdb.Graph NodeRef.graph             N/A
 16   8                long NodeRef.id                N/A
 24   4   overflowdb.NodeDb NodeRef.node              N/A
 28   4                     (object alignment gap)    
Instance size: 32 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifierDb object internals:
OFF  SZ                       TYPE DESCRIPTION                        VALUE
  0   8                            (object header: mark)              N/A
  8   4                            (object header: class)             N/A
 12   1                    boolean NodeDb.dirty                       N/A
 13   3                            (alignment/padding gap)            
 16   4         overflowdb.NodeRef NodeDb.ref                         N/A
 20   4   overflowdb.AdjacentNodes NodeDb.adjacentNodes               N/A
 24   4                        int FieldIdentifierDb._argumentIndex   N/A
 28   4                        int FieldIdentifierDb._order           N/A
 32   4           java.lang.String FieldIdentifierDb._argumentName    N/A
 36   4           java.lang.String FieldIdentifierDb._canonicalName   N/A
 40   4           java.lang.String FieldIdentifierDb._code            N/A
 44   4          java.lang.Integer FieldIdentifierDb._columnNumber    N/A
 48   4          java.lang.Integer FieldIdentifierDb._lineNumber      N/A
 52   4                            (object alignment gap)             
Instance size: 56 bytes
Space losses: 3 bytes internal + 4 bytes external = 7 bytes total


io.shiftleft.codepropertygraph.generated.nodes.LiteralDb object internals:
OFF  SZ                                    TYPE DESCRIPTION                          VALUE
  0   8                                         (object header: mark)                N/A
  8   4                                         (object header: class)               N/A
 12   1                                 boolean NodeDb.dirty                         N/A
 13   3                                         (alignment/padding gap)              
 16   4                      overflowdb.NodeRef NodeDb.ref                           N/A
 20   4                overflowdb.AdjacentNodes NodeDb.adjacentNodes                 N/A
 24   4                                     int LiteralDb._argumentIndex             N/A
 28   4                                     int LiteralDb._order                     N/A
 32   4                        java.lang.String LiteralDb._argumentName              N/A
 36   4                        java.lang.String LiteralDb._code                      N/A
 40   4                       java.lang.Integer LiteralDb._columnNumber              N/A
 44   4   scala.collection.immutable.IndexedSeq LiteralDb._dynamicTypeHintFullName   N/A
 48   4                       java.lang.Integer LiteralDb._lineNumber                N/A
 52   4                        java.lang.String LiteralDb._typeFullName              N/A
Instance size: 56 bytes
Space losses: 3 bytes internal + 0 bytes external = 3 bytes total


io.shiftleft.codepropertygraph.generated.nodes.BlockDb object internals:
OFF  SZ                                    TYPE DESCRIPTION                        VALUE
  0   8                                         (object header: mark)              N/A
  8   4                                         (object header: class)             N/A
 12   1                                 boolean NodeDb.dirty                       N/A
 13   3                                         (alignment/padding gap)            
 16   4                      overflowdb.NodeRef NodeDb.ref                         N/A
 20   4                overflowdb.AdjacentNodes NodeDb.adjacentNodes               N/A
 24   4                                     int BlockDb._argumentIndex             N/A
 28   4                                     int BlockDb._order                     N/A
 32   4                        java.lang.String BlockDb._argumentName              N/A
 36   4                        java.lang.String BlockDb._code                      N/A
 40   4                       java.lang.Integer BlockDb._columnNumber              N/A
 44   4   scala.collection.immutable.IndexedSeq BlockDb._dynamicTypeHintFullName   N/A
 48   4                       java.lang.Integer BlockDb._lineNumber                N/A
 52   4                        java.lang.String BlockDb._typeFullName              N/A
Instance size: 56 bytes
Space losses: 3 bytes internal + 0 bytes external = 3 bytes total


io.shiftleft.codepropertygraph.generated.nodes.FieldIdentifier object internals:
OFF  SZ                TYPE DESCRIPTION               VALUE
  0   8                     (object header: mark)     N/A
  8   4                     (object header: class)    N/A
 12   4    overflowdb.Graph NodeRef.graph             N/A
 16   8                long NodeRef.id                N/A
 24   4   overflowdb.NodeDb NodeRef.node              N/A
 28   4                     (object alignment gap)    
Instance size: 32 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.MethodParameterInDb object internals:
OFF  SZ                                    TYPE DESCRIPTION                                    VALUE
  0   8                                         (object header: mark)                          N/A
  8   4                                         (object header: class)                         N/A
 12   1                                 boolean NodeDb.dirty                                   N/A
 13   1                                 boolean MethodParameterInDb._isVariadic                N/A
 14   2                                         (alignment/padding gap)                        
 16   4                      overflowdb.NodeRef NodeDb.ref                                     N/A
 20   4                overflowdb.AdjacentNodes NodeDb.adjacentNodes                           N/A
 24   4                                     int MethodParameterInDb._index                     N/A
 28   4                                     int MethodParameterInDb._order                     N/A
 32   4                        java.lang.String MethodParameterInDb._code                      N/A
 36   4                       java.lang.Integer MethodParameterInDb._columnNumber              N/A
 40   4   scala.collection.immutable.IndexedSeq MethodParameterInDb._dynamicTypeHintFullName   N/A
 44   4                        java.lang.String MethodParameterInDb._evaluationStrategy        N/A
 48   4                       java.lang.Integer MethodParameterInDb._lineNumber                N/A
 52   4                        java.lang.String MethodParameterInDb._name                      N/A
 56   4                        java.lang.String MethodParameterInDb._typeFullName              N/A
 60   4                                         (object alignment gap)                         
Instance size: 64 bytes
Space losses: 2 bytes internal + 4 bytes external = 6 bytes total


io.shiftleft.codepropertygraph.generated.nodes.Literal object internals:
OFF  SZ                TYPE DESCRIPTION               VALUE
  0   8                     (object header: mark)     N/A
  8   4                     (object header: class)    N/A
 12   4    overflowdb.Graph NodeRef.graph             N/A
 16   8                long NodeRef.id                N/A
 24   4   overflowdb.NodeDb NodeRef.node              N/A
 28   4                     (object alignment gap)    
Instance size: 32 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


io.shiftleft.codepropertygraph.generated.nodes.MethodParameterOutDb object internals:
OFF  SZ                       TYPE DESCRIPTION                                VALUE
  0   8                            (object header: mark)                      N/A
  8   4                            (object header: class)                     N/A
 12   1                    boolean NodeDb.dirty                               N/A
 13   1                    boolean MethodParameterOutDb._isVariadic           N/A
 14   2                            (alignment/padding gap)                    
 16   4         overflowdb.NodeRef NodeDb.ref                                 N/A
 20   4   overflowdb.AdjacentNodes NodeDb.adjacentNodes                       N/A
 24   4                        int MethodParameterOutDb._index                N/A
 28   4                        int MethodParameterOutDb._order                N/A
 32   4           java.lang.String MethodParameterOutDb._code                 N/A
 36   4          java.lang.Integer MethodParameterOutDb._columnNumber         N/A
 40   4           java.lang.String MethodParameterOutDb._evaluationStrategy   N/A
 44   4          java.lang.Integer MethodParameterOutDb._lineNumber           N/A
 48   4           java.lang.String MethodParameterOutDb._name                 N/A
 52   4           java.lang.String MethodParameterOutDb._typeFullName         N/A
Instance size: 56 bytes
Space losses: 2 bytes internal + 0 bytes external = 2 bytes total
```
</details>

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

# Generating domain classes
joern domain (open source): regenerate using `./generateDomainClasses.sh`. The classes are checked into [joern-generated/src/main/scala/generated](joern-generated/src/main/scala/generated)

codescience domain (closed source, qwiet.ai internal): regenerate using `./generateDomainClassesCodescience.sh`. The classes are not checked into this repository. 

N.b. there are many debates about whether to check generated code into repositories.
In this specific case, it is essential to be able to talk about the generated code,
and track its changes over time.

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


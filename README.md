# overflowdbv2

## Core Features
- [x] Access nodes and neighbors
- [x] Add nodes and edges
- [x] Delete edges
- [x] Delete nodes
- [x] Support multiple node types and edge types
- [x] Full support for self-edges; neighbor order is well-defined
- [x] Support node properties
- [x] Support a single optional edge property
- [ ] Support file IO
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

# Odbv1 / Joern benchmarks.
After `sbt clean compile stage` you can run an analogue of `./benchJoern/target/universal/stage/bin/bench-joern -J-Xmx20G -Djdk.attach.allowAttachSelf ./cpg.bin`
to generate some benchmarks (timing and memory consumption). This relies on `jcmd`, so make sure you have the full jdk installed, not
just the jre. For this you need an example graph that you can conveniently generate with joern and take from the workspace 
(don't forget to save). Since this uses joern domain classes, it is incompatible with ocular/codescience graphs. It is also
incompatible with the legacy proto format (just load in joern and save).

Feel free to add more benchmarks or prettify the output!

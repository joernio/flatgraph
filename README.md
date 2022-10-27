# overflowdbv2

## Core Features
- [x] Access nodes and neighbors
- [x] Add nodes and edges
- [x] Delete edges
- [x] Delete nodes
- [x] Support multiple node types and edge types
- [x] Full support for self-edges; neighbor order is well-defined
- [ ] Support node properties
- [x] Support a single optional edge property
- [ ] Support file IO
- [ ] Version counters for stuff like iterator invalidation

## Performance and memory features
- [ ] Support compressed memory representation if actual quantity is 0-1
- [ ] Multi-thread batched update application

## Edge Properties and edge identity
Each edge has a property. The property default and type (String vs Int vs ...) is determined by the schema, and can
depend on edge kind (AST vs CFG), node kind (CALL vs METHOD) and direction (but the types need to be consistent).
The `object DefaultValue` is used as formal default argument to `addEdge`; using it in `setEdgeProperty` will reset the edge's property to its default value.

Primitives are stored unboxed and null values for non-primitives are supported. `NaN` values in Float or Double valued edge properties will
probably blow up some sanity checks / assertions (lol scala, `==` is not reflexive).

It is impossible to determine whether a property has been set to its default value or is missing (has been set to `DefaultValue`).
Edge properties are not stored until they are actually set.

The graph is stored in adjecency lists, and the ordering of the adjecency lists is preserved and well-defined. Batched 
updates to the graph are applied "as if they were unbatched" for the sake of ordering. When an edge is added, then we append 
the required out-neighbors and in-neighbors and properties to the relevant adjacency lists. 

Therefore edges have apriori no identity, and especially no identity on the JVM level; the Edge instances are created on-demand.

Hence, we need a scheme for establishing identity, i.e. a relation between a slot in the out-neighbors of node A that is 
filled with node B, and a slot in the in-neighbors of node B that is filled with node A.The way we do this is the following: 
For edges with `(src=A, dst=B)`, the kth half-edge A->B corresponds to the kth half-edge B<-A. It is clear that addition or 
removal or setting of properties preserves the crucial invariant that paired half-edges have the same property value.

The way we process edge additions establishes a hidden invariant. Consider the following graph:
```
   V0    -> V1, V2
   V1    <- V3, V0
   V2    <- V0, V3
   V3    -> V2, V1
```
Suppose we wanted to construct the graph via edge additions. The ordering of out-neighbors of `V0` implies that the edge
`V0->V1` was added before `V0->V2`; the second line, i.e. the ordering of in-neighbors of V1, implies that `V3->V1` was 
added before `V0->V1`, and so on. These conditions form a cycle, and it is therefore impossible to construct such a graph 
via normal edge additions.

More to the point, when a graph with certain ordering of adjacency lists is desired, then it is quite cumbersome to determine
whether this is possible by edge additions at all, and if so to determine the correct order of edge additions.

For this reason, we also support unsafe additions of half-edges. These are unsafe in the sense that we cannot check validity i.e.
that the reverse half-edge has been added at all and that the paired half-edge has the same property value. Bad half-edges
are liable to lead to exceptions or wrong results later on, but should not pop a shell.

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


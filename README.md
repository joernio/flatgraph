# overflowdbv2

## Core Features
- [x] Access nodes and neighbors
- [x] Add nodes and edges
- [x] Delete edges
- [x] Delete nodes
- [x] Support multiple node types and edge types
- [x] Full support for self-edges; neighbor order is well-defined
- [ ] Support node properties
- [ ] Support a single optional edge property
- [ ] Support file IO
- [ ] Version counters for stuff like iterator invalidation

## Performance and memory features
- [ ] Support compressed memory representation if actual quantity is 0-1
- [ ] Multi-thread batched update application

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
An external property is functionally similar to a `HashMap[Node, T]` without iteration. However, we can use the structured kindId/sequenceId pair with virtually the same indexing scheme to get very fast access and reduced memory consumption, if the external property is "dense", i.e. is defined for most nodes of a kind. A transient external property goes out-of-sync, i.e. becomes invalid, if the graph is modified; a persistent external property stays valid. If we re-index seqIds of nodes, e.g. because of node deletions without tombstones, then external properties become invalid unless we do heroics (heroics would mean: The external proeperty registers itself via WeakRef in the graph, and updates fix the registered external properties).

Via implicits, an external property can be made to look like a "real" property of an object (i.e. it can be used as `val lhs = node.foo` / `node.foo = rhs`), and can be used well in multithreaded contexts (i.e. only the same property on the same node races against itself) with only O(1) total synchronization events, as opposed to hashmaps that require synchronization of some kind on every access (typically via atomics).

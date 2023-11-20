package flatgraph;

/**
 * A GNode represents a node in a graph. It is basically a glorified pointer.
 */
public class GNode implements DNodeOrNode {
    final public Graph graph;

    final public short nodeKind;

    // Sequential ID per node kind.
    int _seqId;

    //an extra field just for this looks quite wasteful. But we have 2 bytes of alignment padding anyways...
    boolean _isDeleted = false;

    final public int seq() {
        return this._seqId;
    }

    /** 
     * Combines nodeKind and seq into a unique id
     * Mostly for backwards compatibility with overflowdb v1 where nodes have a `id: Long`
     */
    final public long id() {
        // Promote nodeKind (short) to a higher area using left shift and combine with int
        // note: masking the seq with 0x00000000ffffffffL to ensure that we treat is as an unsigned 32-bit integer - 
        // shouldn't really be necessary, but better safe than sorry
        return ((long) nodeKind << 32) | (seq() & 0x00000000ffffffffL);
    }

    public GNode(Graph graph, short nodeKind, int seqId) {
        this.nodeKind = nodeKind;
        this._seqId = seqId;
        this.graph = graph;
    }

    public String label() {
        return graph.schema().getNodeLabel(nodeKind);
    }
}

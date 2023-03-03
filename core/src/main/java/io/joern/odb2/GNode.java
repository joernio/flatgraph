package io.joern.odb2;

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

    public GNode(Graph graph, short nodeKind, int seqId) {
        this.nodeKind = nodeKind;
        this._seqId = seqId;
        this.graph = graph;
    }

    public String label() {
        return graph.schema().getNodeLabel(nodeKind);
    }
}

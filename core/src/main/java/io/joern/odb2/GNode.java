package io.joern.odb2;

public class GNode implements DNodeOrNode{
    final public Graph graph;

    final public short kindId;
    final public int seqId;

    public GNode( Graph graph, short kindId, int seqId) {
        this.kindId = kindId;
        this.seqId = seqId;
        this.graph = graph;
    }
}

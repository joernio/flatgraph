package flatgraph;

import flatgraph.misc.DebugDump;

import java.util.Objects;

/**
 * A GNode represents a node in a graph. It is basically a glorified pointer.
 */
public class GNode implements DNodeOrNode {
    final public Graph graph;

    final public short nodeKind;

    // we don't really have an id, but we can generate one by combining the ints nodeKind and seqId into a long
    // note: masking the seq with 0x00000000ffffffffL to ensure that we treat is as an unsigned 32-bit integer -
    // shouldn't really be necessary, but better safe than sorry
    final public static long ID_SEQ_MASK = 0x00000000ffffffffL;
    final public static int ID_KIND_SHIFT = 32;

    // Sequential ID per node kind.
    int _seqId;

    //an extra field just for this looks quite wasteful. But we have 2 bytes of alignment padding anyways...
    boolean _isDeleted = false;

    /** the unique identifier for a node of _this kind_ */
    final public int seq() {
        return this._seqId;
    }

    /** 
     * Combines nodeKind and seq into a unique id (for this graph)
     * Mostly for backwards compatibility with overflowdb v1 where nodes have a `id: Long`
     */
    final public long id() {
        return GNode.computeId(nodeKind, seq());
    }

    public GNode(Graph graph, short nodeKind, int seqId) {
        this.nodeKind = nodeKind;
        this._seqId = seqId;
        this.graph = graph;
    }

    public String label() {
        return graph.schema().getNodeLabel(nodeKind);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[label=" + label() + "; seq=" + seq() + "; id=" + id() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(graph, nodeKind, _seqId);
    }

    /** Combines the (32 bit) integer values `nodeKind` and `seq` into one (64 bit) long `id`.
     * Reverse: `computeKindAndSeq` */
    public static long computeId(int nodeKind, int seq) {
        return ((long) nodeKind << ID_KIND_SHIFT) | (seq & ID_SEQ_MASK);
    }

    /** Extracts the (32 bit) integer value `nodeKind` (64 bit) long `id`. */
    public static int extractKind(long id) {
        return (int) (id >> ID_KIND_SHIFT);
    }

    /** Extracts the (32 bit) integer value `seq` (64 bit) long `id`. */
    public static int extractSeq(long id) {
        return (int) (id & ID_SEQ_MASK);
    }

    /** Extracts the (32 bit) integer values `nodeKind` and `seq` from the  (64 bit) long `id`. */
    public static KindAndSeq computeKindAndSeq(long id) {
        return new KindAndSeq(extractKind(id), extractSeq(id));
    }

    public static class KindAndSeq {
        public final int kind;
        public final int seq;
        public KindAndSeq(int kind, int seq) {
            this.kind = kind;
            this.seq = seq;
        }
    }

    /** This creates a representation of the node that is suitable for debugging, e.g. in intellij.
     * This function corresponds to the childrenArray() API in intellij.*/
    public Object[] _debugChildren(){
        return DebugDump.debugChildrenScala(this);
    }
}

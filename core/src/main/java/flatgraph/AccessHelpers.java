package flatgraph;

/**
 * This class serves as a collection of accessors for package-private fields.
 * <p>
 * It can be used from other packages, but don't do this without need!
 */
public class AccessHelpers {
    public static boolean isDeleted(GNode node) {
        return node._isDeleted;
    }

    public static void markDeleted(GNode node) {
        node._isDeleted = true;
    }

    public static void setSeqId(GNode node, int seqId) {
        node._seqId = seqId;
    }
}

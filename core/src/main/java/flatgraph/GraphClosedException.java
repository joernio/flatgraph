package flatgraph;

public class GraphClosedException extends RuntimeException {
    public GraphClosedException(String message) {
        super(message);
    }

    public GraphClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}

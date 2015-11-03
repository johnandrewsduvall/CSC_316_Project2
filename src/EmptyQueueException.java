public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("removal attempted when queue is empty");
    }
}
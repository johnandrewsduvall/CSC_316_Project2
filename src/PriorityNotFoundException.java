public class PriorityNotFoundException extends Exception {
    public int priority;

    public PriorityNotFoundException(int p) {
        super("there is no ticket with priority = " + p + " in the queue");
        this.priority = p;
    }
}
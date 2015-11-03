public class DuplicatePriorityException extends Exception {
    public int priority;

    public DuplicatePriorityException(int p) {
        super("a ticket with priority " + p +  "is already in the queue");
        this.priority = p;
    }
}
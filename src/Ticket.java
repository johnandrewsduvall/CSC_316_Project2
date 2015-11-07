/**
 * 
 * @author Matthew Watkins
 * Ticket structure
 */

public class Ticket {
    public long id;
    public long priority;
    public long position;

    public Ticket(long id, long priority) {
        this.id = id;
        this.priority = priority;
    }

    public Ticket(long id, long priority, long position) {
        this.id = id;
        this.priority = priority;
        this.position = position;
    }
}
/**
 *
 * @author Matthew Watkins
 * Ticket structure
 */

public class Ticket {
    public int id;
    public int priority;
    public int position;

    public Ticket(int id, int priority, int position) {
        this.id = id;
        this.priority = priority;
        this.position = position;
    }
}
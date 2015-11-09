/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

/**
 * Ticket structure.
 * @author Matthew Watkins
 */
public class Ticket {
    /** An int that represents a ticket's id. */
    public int id;
    /** An int that represents a ticket's priority. */
    public int priority;
    /** An int that represents a ticket's position. */
    public int position;
    
    /**
     * Constructor of Ticket class.
     * @param id ticket's id
     * @param priority ticket's priority
     * @param position ticket's position
     */
    public Ticket(int id, int priority, int position) {
        this.id = id;
        this.priority = priority;
        this.position = position;
    }
}
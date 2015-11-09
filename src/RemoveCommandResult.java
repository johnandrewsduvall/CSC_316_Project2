/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

/**
 * This class print the result of removes a ticket.
 * @author Shujun Ye
 */
public class RemoveCommandResult extends CommandResult {
    /** An int that represents a priority of a ticket. */
    private int priority;
    /** An int that represents a position of a ticket. */
    private int position;
    
    /**
     * Constructor of RemoveCommandResult class.
     * @param priority ticket's priority
     * @param position ticket's position
     */
    public RemoveCommandResult(int priority, int position){
        this.priority = priority;
        this.position = position;
    }
    @Override
    /**
     * This method prints the result of RemoveCommandResult.
     * @return formats ticket data into human readable string
     */
    public String print() {
        return this.priority + ", pos = " + position;
    }
}

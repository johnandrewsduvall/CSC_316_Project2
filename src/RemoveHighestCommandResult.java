/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

/**
 * This class print the result of removes the ticket with highest priority.
 * @author Shujun Ye
 */
public class RemoveHighestCommandResult extends CommandResult {
    /** A long that represents id, which is consecutive positive integer. */
    private long id;
    /** A long that represents a priority of a ticket. */
    private long priority;
    
    /**
     * Construct of RemoveHighestCommandResult class.
     * @param id ticket's id
     * @param priority ticket's priority
     */
    public RemoveHighestCommandResult (long id, long priority){
        this.id = id;
        this.priority = priority;
    }
    
    @Override
    /**
     * This method prints the result of RemoveHighestCommandResult.
     * @return formats ticket data into human readable string
     */
    public String print() {
        return "id = " + this.id + ", " + this.priority;
    }
}

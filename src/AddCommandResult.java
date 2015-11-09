/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

/**
 * This class print the result of add a ticket with the given priority.
 * @author Matthew Watkins
 * @author Shujun Ye
 * @author John Andrew Duvall
 */
public class AddCommandResult extends CommandResult {
    /** An int that represents id, which is consecutive positive integer. */
    public int id;
    
    /**
     * Constuctor of AddCommandResult class.
     * @param id ticket's id
     */
    public AddCommandResult(int id) {
        this.id = id;
    }

    /**
     * This method prints the result of AddCommandResult.
     * @return formats ticket data into human readable string
     */
    public String print() {
        return "id = " + id;
    }
}

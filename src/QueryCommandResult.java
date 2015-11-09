/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

/**
 * This class print the result of QueryCommand.
 * @author Shujun Ye
 */
public class QueryCommandResult extends CommandResult {
    /** The position of the ticket. */
    private int position;
    
    /**
     * Constuctor of QueryCommandResult.
     * @param position the current position of the ticket.
     * @throws Exception if the data is invalid.
     */
    public QueryCommandResult(int position) throws Exception{
        this.position = position;
    }
    
    /**
     * This method prints the result of QueryCommandResult.
     * @return formats ticket data into human readable string
     */
    public String print() {
        return "pos = " + this.position;
    }
}
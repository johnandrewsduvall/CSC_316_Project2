/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

/**
 * This class finds current position in the queue of the ticket with the givn id.
 * @author Shujun Ye
 */
public class QueryCommand extends Command<QueryCommandResult> {
    /** The ticket's id. */
    private int id;
    /**
     * Constructor of QueryCommand class.
     * @param id ticket's id
     */
    public QueryCommand (int id){
        this.id = id;
    }

    @Override
    /**
     * This mehtod runs ticket system and finds current position in the queue of the ticket with the givn id.
     * @param ticketSystem the ticket system
     * @return the result of QueryCommandResult
     * @throws Exception if it is invalid data
     */
    public QueryCommandResult run(TicketSystem ticketSystem) throws Exception{
        return new QueryCommandResult(ticketSystem.get(this.id).position);
    }
}

/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

/**
 * This class removes a ticket.
 * @author Shujun Ye
 */
public class RemoveCommand extends Command<RemoveCommandResult> {
    /** An int that represents a ticket's id. */
    private int ticketId;
    
    /**
     * Constructor of RemoveCommand class.
     * @param ticketId ticket's id
     */
    public RemoveCommand(int ticketId){
        this.ticketId = ticketId;
    }
    
    @Override
    /**
     * This mehtod runs ticket system and removes a ticket.
     * @param ticketSystem the ticket system
     * @return the result of RemoveCommandResult
     * @throws Exception if it is invalid data
     */
    public RemoveCommandResult run(TicketSystem ticketSystem) throws Exception{
        Ticket result = ticketSystem.remove(ticketId);
        return new RemoveCommandResult(result.priority, result.position);
    }
}
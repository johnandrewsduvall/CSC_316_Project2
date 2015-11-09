/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

/**
 * This class removes ticket with highest priority.
 * @author Shujun Ye
 */
public class RemoveHighestCommand extends Command<RemoveHighestCommandResult> {

    @Override
    /**
     * This method runs ticketSystem and removes ticket with highest priority.
     * @param ticketSystem the ticket system
     * @return the result of RemoveHishestCommandResult
     * @throws Exception if it is invalid data
     */
    public RemoveHighestCommandResult run(TicketSystem ticketSystem) throws Exception{
        Ticket result = ticketSystem.removeHighest();
        return new RemoveHighestCommandResult(result.id, result.priority);
    }
}

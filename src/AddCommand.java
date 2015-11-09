/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

/**
 * This class adds a ticket with the given priority.
 * @author John Andrew S Duvall
 * @author Matthew Watkins
 * @author Shujun Ye
 */
public class AddCommand extends Command<AddCommandResult> {
    /** An integer that represents a priority of a ticket. */
    private int priority;
    
    /**
     * Constructor of AddCommand class.
     * @param priority a priority of a ticket
     */
    public AddCommand(int priority) {
        this.priority = priority;
    }

    @Override
    /**
     * This method runs ticket system and adds a ticket with the given priority. 
     * @param ticketSystem the ticket system
     * @return the result of AddCommandResult
     * @throws Exception if it is invalid data
     */
    public AddCommandResult run(TicketSystem ticketSystem) throws Exception {
        return new AddCommandResult(ticketSystem.add(this.priority).id);
    }
}

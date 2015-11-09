/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

/**
 * Interface defining Command class.
 * @author Matthew Watkins
 * @author Shujun Ye
 * @author John Andrew Duvall
 * @param <E> object
 */
public abstract class Command<E extends CommandResult> {
    /**
     * The abstract class for run method. 
     * @param ticketsystem the ticket system.
     * @param <E> object
     * @throws Exception if it is invalid data.
     */
    public abstract E run(TicketSystem ticketSystem) throws Exception;
}
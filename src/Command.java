/**
 * @author Matthew Watkins
 * @author Shujun Ye
 * @author John Andrew Duvall
 * @param <E> 
 * Interface defining Command class
 */
public abstract class Command<E extends CommandResult> {
    public abstract E run(TicketSystem ticketSystem) throws Exception;
}
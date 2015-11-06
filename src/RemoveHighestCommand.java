/**
 * @author Shujun Ye
 */
public class RemoveHighestCommand extends Command<RemoveHighestCommandResult> {
    public RemoveHighestCommandResult run(TicketSystem ticketSystem) throws Exception{
        Ticket result = ticketSystem.removeHighest(true);
        return new RemoveHighestCommandResult(result.id, result.priority);
    }
}
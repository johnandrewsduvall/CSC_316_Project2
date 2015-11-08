/**
 * @author Shujun Ye
 */
public class RemoveHighestCommand extends Command<RemoveHighestCommandResult> {

    @Override
    public RemoveHighestCommandResult run(TicketSystem ticketSystem) throws Exception{
        Ticket result = ticketSystem.removeHighest();
        return new RemoveHighestCommandResult(result.id, result.priority);
    }
}
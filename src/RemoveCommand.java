/**
 * @author Shujun Ye
 */
public class RemoveCommand extends Command<RemoveCommandResult> {
    private int ticketId;
    public RemoveCommand(int ticketId){
        this.ticketId = ticketId;
    }
    public RemoveCommandResult run(TicketSystem ticketSystem) throws Exception{
        Ticket result = ticketSystem.removeID(ticketId, true);
        return new RemoveCommandResult(result.priority, result.position);
    }
}
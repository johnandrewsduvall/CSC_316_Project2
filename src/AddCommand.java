public class AddCommand extends Command<AddCommandResult> {
    private int priority;

    public AddCommand(int priority) {
        this.priority = priority;
    }

    public AddCommandResult execute(TicketSystem ticketSystem) {
        Ticket ticket = ticketSystem.addTicket(this.priority);
        AddCommandResult result = new AddCommandResult(ticket.id);
        result.success = true;
        return result;
    }
}
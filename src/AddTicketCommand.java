public class AddTicketCommand extends Command<AddTicketCommandResult> {
    private int priority;
    
    public AddTicketCommand(int priority) {
        this.priority = priority;
    }

    public AddTicketCommandResult execute(TicketSystem ticketSystem) {
        Ticket ticket = ticketSystem.addTicket(this.priority);
        AddTicketCommandResult result = new AddTicketCommandResult(ticket.id);
        result.success = true;
        return result;
    }
}
public class AddTicketCommand extends Command<AddTicketCommandResult> {
    public int priority;

    public AddTicketCommandResult execute(TicketSystem ticketSystem) {
        AddTicketCommandResult result = new AddTicketCommandResult();
        result.id = ticketSystem.addTicket(this.priority);
        return result;
    }
}
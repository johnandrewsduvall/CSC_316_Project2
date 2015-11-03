public class AddCommand extends Command<AddCommandResult> {
    private int priority;

    public AddCommand(int priority) {
        this.priority = priority;
    }

    public AddCommandResult execute(TicketSystem ticketSystem) {
        AddCommandResult result = new AddCommandResult();
        try {
            Ticket ticket = ticketSystem.add(this.priority);
            result.id = ticket.id;
            result.success = true;
        } catch (Exception e) {
            result.errorMessage = e.getMessage();
        }
        return result;
    }
}
public class AddCommand extends Command<AddCommandResult> {
    private int priority;

    public AddCommand(int priority) {
        this.priority = priority;
    }

    public AddCommandResult run(TicketSystem ticketSystem) throws Exception {
        return new AddCommandResult(ticketSystem.add(this.priority).id);
    }
}
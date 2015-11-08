public class AddCommand extends Command<AddCommandResult> {
    private int priority;

    public AddCommand(int priority) {
        this.priority = priority;
    }

    @Override
    public AddCommandResult run(TicketSystem ticketSystem) throws Exception {
        return new AddCommandResult(ticketSystem.add(this.priority).id);
    }
}
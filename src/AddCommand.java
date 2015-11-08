public class AddCommand extends Command<AddCommandResult> {
    private long priority;

    public AddCommand(long priority) {
        this.priority = priority;
    }

    @Override
    public AddCommandResult run(TicketSystem ticketSystem) throws Exception {
        return new AddCommandResult(ticketSystem.add(this.priority).id);
    }
}
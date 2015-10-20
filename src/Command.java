public abstract class Command<E extends CommandResult> {
    public abstract E execute(TicketSystem ticketSystem);
}
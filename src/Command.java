public abstract class Command<E extends CommandResult> {
    public abstract E run(TicketSystem ticketSystem) throws Exception;
}
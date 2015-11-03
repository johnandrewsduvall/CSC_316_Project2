public class TicketNotFoundException extends Exception {
    public int ticketID;

    public TicketNotFoundException(int ticketID) {
        super("there is no ticket with id = " + ticketID + " in the queue");
        this.ticketID = ticketID;
    }
}
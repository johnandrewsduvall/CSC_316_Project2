import java.util.*;

public class TicketSystem {
    private TreeMap<Integer, Integer> _priorityMap;
    private TreeMap<Integer, Integer> _ticketMap;
    private int _maxTicketID;

    public TicketSystem() {
        _priorityMap = new TreeMap<Integer, Integer>();
        _ticketMap = new TreeMap<Integer, Integer>();
    }

    // ADD method
    public Ticket addTicket(int priority) {
        int newTicketID = getNextTicketID();
        _priorityMap.put(priority, newTicketID);
        _ticketMap.put(newTicketID, priority);
        return new Ticket(newTicketID, priority);
    }

    // REMOVE methods
    public Ticket removeHighestPriorityTicket(boolean getPos) {
        return removeTicketByPriority(_priorityMap.lastKey(), getPos);
    }

    public Ticket removeTicketByPriority(int priority, boolean getPos) {
        int ticketID = _priorityMap.get(priority);
        return removeTicket(ticketID, priority, getPos);
    }

    public Ticket removeTicketByID(int ticketID, boolean getPos) {
        int priority = _ticketMap.get(ticketID);
        return removeTicket(ticketID, priority, getPos);
    }

    // QUERY methods
    public int getPositionByID(int ticketID) {
        int priority = _ticketMap.get(ticketID);
        return getPositionByPriority(priority);
    }

    public int getPositionByPriority(int ticketPriority) {
        int position = 0;
        for (int priority : _priorityMap.descendingKeySet()) {
            position++;
            if (priority == ticketPriority) {
                break;
            }
        }
        return position;
    }

    // PRIVATE methods
    private int getNextTicketID() {
        return ++_maxTicketID;
    }

    private Ticket removeTicket(int ticketID, int priority, boolean getPos) {
        // Get the ticket
        Ticket ticket = null;
        if (getPos) {
            int position = getPositionByPriority(priority);
            ticket = new Ticket(ticketID, priority, position);
        } else {
            ticket = new Ticket(ticketID, priority);
        }

        // Remove the ticket
        _priorityMap.remove(priority);
        _ticketMap.remove(ticketID);

        // Return the ticket
        return ticket;
    }
}
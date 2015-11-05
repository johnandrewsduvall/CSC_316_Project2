import java.util.*;

public class TicketSystem {
  // Map of priority -> ticket ID
  private TreeMap<Integer, Integer> _priorityToID;

  // Map of ticket ID -> priority
  private TreeMap<Integer, Integer> _idToPriority;

  // The highest ticket ID in the system
  private int _maxTicketID;

  public TicketSystem() {
    _priorityToID = new TreeMap<Integer, Integer>();
    _idToPriority = new TreeMap<Integer, Integer>();
  }

  public Ticket add(int priority) throws Exception {
    ensurePriorityIsNew(priority);
    int newTicketID = getNextTicketID();
    _priorityToID.put(priority, newTicketID);
    _idToPriority.put(newTicketID, priority);
    return new Ticket(newTicketID, priority);
  }

  public Ticket removeHighest(boolean getPos) throws Exception {
    ensureQueueIsNotEmpty();
    int highestPriority = _priorityToID.lastKey();
    return remove(_priorityToID.get(highestPriority), highestPriority, getPos);
  }

  public Ticket removePriority(int priority, boolean getPos) throws Exception {
    ensureQueueIsNotEmpty();
    ensurePriorityExists(priority);
    return remove(_priorityToID.get(priority), priority, getPos);
  }

  public Ticket removeID(int ticketID, boolean getPos) throws Exception {
    ensureQueueIsNotEmpty();
    ensureIdExists(ticketID);
    return remove(ticketID, _idToPriority.get(ticketID), getPos);
  }

  public int getPositionByID(int ticketID) throws Exception {
    ensureQueueIsNotEmpty();
    ensureIdExists(ticketID);
    return getPosition(_idToPriority.get(ticketID));
  }

  public int getPositionByPriority(int ticketPriority) throws Exception {
    ensureQueueIsNotEmpty();
    ensurePriorityExists(ticketPriority);
    return getPosition(ticketPriority);
  }

  /*
   * PRIVATE METHODS
   */
  private int getNextTicketID() {
    return ++_maxTicketID;
  }

  private void ensureQueueIsNotEmpty() throws Exception {
    if (_priorityToID.isEmpty()) {
      throw new Exception("removal attempted when queue is empty");
    }
  }

  private void ensureIdExists(int id) throws Exception {
    if (!_idToPriority.containsKey(id)) {
      throw new Exception("there is no ticket with id = "
        + id + " in the queue");
    }
  }

  private void ensurePriorityExists(int p) throws Exception {
    if (!_priorityToID.containsKey(p)) {
      throw new Exception("there is no ticket with priority = "
        + p + " in the queue");
    }
  }

  private void ensurePriorityIsNew(int p) throws Exception {
    if (_idToPriority.containsKey(p)) {
      throw new Exception("a ticket with priority "
        + p + " is already in the queue");
    }
  }

  private Ticket remove(int ticketID, int priority, boolean getPos) {
    Ticket ticket = null;
    if (getPos) {
      int position = getPosition(priority);
      ticket = new Ticket(ticketID, priority, position);
    } else {
      ticket = new Ticket(ticketID, priority);
    }
    _priorityToID.remove(priority);
    _idToPriority.remove(ticketID);
    return ticket;
  }

  private int getPosition(int priority) {
    int position = 0;
    for (int p : _priorityToID.descendingKeySet()) {
      position++;
      if (p == priority) {
        break;
      }
    }
    return position;
  }
}
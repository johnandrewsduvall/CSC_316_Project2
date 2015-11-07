import java.util.*;

public class TicketSystem {
  // Map of priority -> ticket ID
  private TreeMap<Long, Long> _priorityToID;

  // Map of ticket ID -> priority
  private TreeMap<Long, Long> _idToPriority;

  // The highest ticket ID in the system
  private long _maxTicketID;

  public TicketSystem() {
    _priorityToID = new TreeMap<Long, Long>();
    _idToPriority = new TreeMap<Long, Long>();
  }

  public Ticket add(long priority) throws Exception {
    ensurePriorityIsNew(priority);
    long newTicketID = getNextTicketID();
    _priorityToID.put(priority, newTicketID);
    _idToPriority.put(newTicketID, priority);
    return new Ticket(newTicketID, priority);
  }

  public Ticket removeHighest(boolean getPos) throws Exception {
    ensureQueueIsNotEmpty();
    long highestPriority = _priorityToID.lastKey();
    return remove(_priorityToID.get(highestPriority), highestPriority, getPos);
  }

  public Ticket removePriority(long priority, boolean getPos) throws Exception {
    ensureQueueIsNotEmpty();
    ensurePriorityExists(priority);
    return remove(_priorityToID.get(priority), priority, getPos);
  }

  public Ticket removeID(long ticketID, boolean getPos) throws Exception {
    ensureQueueIsNotEmpty();
    ensureIdExists(ticketID);
    return remove(ticketID, _idToPriority.get(ticketID), getPos);
  }

  public long getPositionByID(long ticketID) throws Exception {
    ensureQueueIsNotEmpty();
    ensureIdExists(ticketID);
    return getPosition(_idToPriority.get(ticketID));
  }

  public long getPositionByPriority(long ticketPriority) throws Exception {
    ensureQueueIsNotEmpty();
    ensurePriorityExists(ticketPriority);
    return getPosition(ticketPriority);
  }

  /*
   * PRIVATE METHODS
   */
  private long getNextTicketID() {
    return ++_maxTicketID;
  }

  private void ensureQueueIsNotEmpty() throws Exception {
    if (_priorityToID.isEmpty()) {
      throw new Exception("removal attempted when queue is empty");
    }
  }

  private void ensureIdExists(long id) throws Exception {
    if (!_idToPriority.containsKey(id)) {
      throw new Exception("there is no ticket with id = "
        + id + " in the queue");
    }
  }

  private void ensurePriorityExists(long p) throws Exception {
    if (!_priorityToID.containsKey(p)) {
      throw new Exception("there is no ticket with priority = "
        + p + " in the queue");
    }
  }

  private void ensurePriorityIsNew(long p) throws Exception {
    if (_idToPriority.containsKey(p)) {
      throw new Exception("a ticket with priority "
        + p + " is already in the queue");
    }
  }

  private Ticket remove(long ticketID, long priority, boolean getPos) {
    Ticket ticket = null;
    if (getPos) {
      long position = getPosition(priority);
      ticket = new Ticket(ticketID, priority, position);
    } else {
      ticket = new Ticket(ticketID, priority);
    }
    _priorityToID.remove(priority);
    _idToPriority.remove(ticketID);
    return ticket;
  }

  private long getPosition(long priority) {
    SortedMap<Long, Long> tailMap = _priorityToID.tailMap(priority);
    return tailMap.size();
  }
}
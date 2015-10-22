import java.util.*;

public class TicketSystem {
    private TreeMap<Integer, ArrayList<Integer>> _priorityMap;
    private TreeMap<Integer, Integer> _idPriorityMap;
    private int maxID;

    public TicketSystem() {
        _priorityMap = new TreeMap<Integer, ArrayList<Integer>>();
        _idPriorityMap = new TreeMap<Integer, Integer>();
    }

    public Ticket removeHighestPriorityTicket() {
        int highestPriority = _priorityMap.lastKey();
        return removeTicket(_priorityMap.get(highestPriority).get(0));
    }

    public Ticket removeTicket(int id) {
        int priority = _idPriorityMap.get(id);
        int position = getTicketQueuePosition(id, priority);
        ArrayList<Integer> priorityList = _priorityMap.get(priority);
        priorityList.remove((Integer)id);
        if (priorityList.size() == 0) {
            _priorityMap.remove(priority);
        }
        _idPriorityMap.remove(id);
        return new Ticket(id, priority, position);
    }

    public Ticket addTicket(int priority) {
        if (!_priorityMap.containsKey(priority)) {
            _priorityMap.put(priority, new ArrayList<Integer>());
        }
        int id = ++maxID;
        _priorityMap.get(priority).add(id);
        _idPriorityMap.put(id, priority);
        return new Ticket(id, priority);
    }

    public int getTicketQueuePosition(int id) {
        return getTicketQueuePosition(id, _idPriorityMap.get(id));
    }

    private int getTicketQueuePosition(int id, int thisPriority) {
        int position = 0;
        for (int priority : _priorityMap.descendingKeySet()) {
            ArrayList<Integer> priorityIDs = _priorityMap.get(priority);
            if (priority > thisPriority) {
                position += priorityIDs.size();
            } else if (priority == thisPriority) {
                position += priorityIDs.indexOf(id) + 1;
                break;
            }
        }
        return position;
    }
}
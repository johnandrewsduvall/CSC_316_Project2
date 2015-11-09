/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */
import java.util.*;

/**
 * Ticket System.
 */
public class TicketSystem {
    private TreeMap<Integer, Integer> _idMap = new TreeMap<Integer, Integer>();
    private TreeMap<Integer, Integer> _pMap = new TreeMap<Integer, Integer>();
    private ArrayList<Integer> _tickets = new ArrayList<Integer>();
    private int _maxID;
    
    /**
     * Constructor of TicketSystem.
     */
    public TicketSystem() {
        
    }
    
    /*
     * Public methods
     */
    public Ticket add(int priority) throws Exception {
        int idx = 0;
        if (_tickets.size() > 0) {
            idx = getPriorityIndex(priority, 0, _tickets.size() - 1);
            int priorityAtIdx = _tickets.get(idx);
            if (priorityAtIdx == priority) {
                errorDuplicatePriority(priority);
            }
        }
        _idMap.put(++_maxID, priority);
        _pMap.put(priority, _maxID);
        _tickets.add(idx, priority);
        return new Ticket(_maxID, priority, idx + 1);
    }
    
    public Ticket removeHighest() throws Exception {
        // Validation
        ensureQueueIsNotEmpty();
        
        // Get/remove it
        int highestPriority = _tickets.get(0);
        int id = _pMap.remove(highestPriority);
        _idMap.remove(id);
        int val = _tickets.remove(0);
        
        // Return it
        return new Ticket(id, highestPriority, 1);
    }
    
    public Ticket remove(int id) throws Exception {
        // Validation
        ensureQueueIsNotEmpty();
        ensureIdExists(id);
        
        // Get/remove it
        int priority = _idMap.remove(id);
        _pMap.remove(priority);
        int idx = getPriorityIndex(priority);
        int val = _tickets.remove(idx);
        
        // Return it
        return new Ticket(id, priority, idx + 1);
    }
    
    public Ticket get(int id) throws Exception {
        // Validation
        ensureQueueIsNotEmpty();
        ensureIdExists(id);
        
        // Get the priority and index
        int priority = _idMap.get(id);
        int idx = getPriorityIndex(priority);
        
        // Return it
        return new Ticket(id, priority, idx + 1);
    }
    
    /*
     * Private methods
     */
    private int getPriorityIndex(int priority) {
        return getPriorityIndex(priority, 0, _tickets.size() - 1);
    }
    
    private int getPriorityIndex(int priority, int idxLo, int idxHi) {
        if (idxHi - idxLo == 1) {
            return getPriorityIdxFromAdjacent(priority, idxLo, idxHi);
        }
        return getPriorityIdxFromSubtree(priority, idxLo, idxHi);
    }
    
    private int getPriorityIdxFromAdjacent(int p, int idxLo, int idxHi) {
        // Check against the lower node
        int higherPriority = _tickets.get(idxLo);
        if (p >= higherPriority) {
            // Matches or should prepend this node
            return idxLo;
        }
        
        // Check against the higher node
        int lowerPriority = _tickets.get(idxHi);
        if (p >= lowerPriority) {
            // Matches or should prepend this node
            return idxHi;
        }
        
        // Should append this node
        return idxHi + 1;
    }
    
    private int getPriorityIdxFromSubtree(int priority, int idxLo, int idxHi) {
        // Get the ticket to compare against (next tree node root)
        int idxDiff = idxHi - idxLo;
        int compIdx = idxLo + (idxDiff / 2);
        int compPriority = _tickets.get(compIdx);
        
        // Equal priority
        if (priority == compPriority) {
            return compIdx;
        }
        
        // Higher priority
        if (priority > compPriority) {
            if (idxDiff == 0) {
                // Should prepend this node
                return compIdx;
            }
            // Somewhere farther down the line; go down another level left
            return getPriorityIndex(priority, idxLo, compIdx - 1);
        }
        
        // Lower priority
        if (idxDiff == 0) {
            // Should append this node
            return compIdx + 1;
        }
        // Somewhere farther down the line; go down another level right
        return getPriorityIndex(priority, compIdx, idxHi);
    }
    
    private void ensureQueueIsNotEmpty() throws Exception {
        if (_tickets.isEmpty()) {
            errorEmptyQueue();
        }
    }
    
    private void ensureIdExists(int id) throws Exception {
        if (!_idMap.containsKey(id)) {
            errorIdDoesNotExist(id);
        }
    }
    
    private void errorEmptyQueue() throws Exception {
        throw new Exception("removal attempted when queue is empty");
    }
    
    private void errorDuplicatePriority(int p) throws Exception {
        throw new Exception("a ticket with priority " + p
                            + " is already in the queue");
    }
    
    private void errorIdDoesNotExist(int id) throws Exception {
        throw new Exception("there is no ticket with id = " + id
                            + " in the queue");
    }
}
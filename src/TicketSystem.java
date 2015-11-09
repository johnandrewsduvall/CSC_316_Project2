/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */
import java.util.*;

/**
 * The main logic handler to process changes to the ticket priority queue.
 * It utilizes two maps to quickly keep track of IDs <-> priority
 * and an ArrayList to hold tickets in descending (highest priority)
 * order. The ArrayList of tickets is treated as a Binary Search Tree,
 * allowing for very fast operations, but uses a flat structure to allow
 * for very simple and fast inorder traversal. This means position doesn't have
 * to be stored or modified at runtime-- the position is merely derived by
 * adding 1 to the index of the element queried. Additionally, because
 * of the fact that the ArrayList is searched as a binary tree, it can be
 * considered auto-balancing in this respect since parent nodes exist only
 * conceptually and not as an actual data structure.
 *
 * @author Matthew Watkins
 * @author John Andrew Duvall
 * @author Shujun Ye
 */
public class TicketSystem {
    /**
    * Map of ID -> priority
    */
    private TreeMap<Integer, Integer> _idMap = new TreeMap<Integer, Integer>();

    /**
    * Map of priority -> ID
    */
    private TreeMap<Integer, Integer> _pMap = new TreeMap<Integer, Integer>();

    /**
    * List of ticket priorities in order (treated as binary search tree)
    */
    private ArrayList<Integer> _tickets = new ArrayList<Integer>();

    /**
    * The max ID of the list (incremented each add)
    */
    private int _maxID;

    /**
     * Adds a ticket with the specified priority to the queue
     * @param priority the priority to be inserted
     * @return the new ticket
     */
    public Ticket add(int priority) throws Exception {
        // Initially assume an insertion index of 0
        int idx = 0;

        // Only find the actual index if the queue is not empty
        if (_tickets.size() > 0) {
            // Get the expected index where we would insert this ticket
            idx = getPriorityIndex(priority);

            // See if it will be inserted within the existing bounds
            if (idx < _tickets.size()) {
                // This ticket will be prepended to an existing ticket
                int priorityAtIdx = _tickets.get(idx);

                // Make sure the existing ticket is not a duplicate
                if (priorityAtIdx == priority) {
                    // It is a duplicate priority. Error it (exception)
                    errorDuplicatePriority(priority);
                }
            }
        }

        // Inc max ID and store ID -> priority map
        _idMap.put(++_maxID, priority);

        // Store priority -> ID map
        _pMap.put(priority, _maxID);

        // Add the ticket to the Array / BST
        _tickets.add(idx, priority);

        // Return the new ticket info
        return new Ticket(_maxID, priority, idx + 1);
    }

    /**
     * Removes the highest priority ticket from the queue
     * @return the ticket that was removed
     */
    public Ticket removeHighest() throws Exception {
        // Validation
        ensureQueueIsNotEmpty();

        // Get the highest priority from the queue
        int highestPriority = _tickets.get(0);

        // Get/remove the mapping of that Priority -> ID
        int id = _pMap.remove(highestPriority);

        // Remove the mapping of that ID -> Priority
        _idMap.remove(id);

        // Remove the ticket at the index
        int val = _tickets.remove(0);

        // Return it
        return new Ticket(id, highestPriority, 1);
    }

    /**
     * Removes the ticket with the specified ID from the queue
     * @param id the ID of the ticket to be removed
     * @return the ticket that was removed
     */
    public Ticket remove(int id) throws Exception {
        // Validation
        ensureQueueIsNotEmpty();
        ensureIdExists(id);

        // Get/remove the priority from the ID -> Priority map
        int priority = _idMap.remove(id);

        // Remove the priority from the prioity -> ID map
        _pMap.remove(priority);

        // Get the index of the priority in the queue
        int idx = getPriorityIndex(priority);

        // Remove the ticket from the queue
        int val = _tickets.remove(idx);

        // Return the ticket details
        return new Ticket(id, priority, idx + 1);
    }

    /**
     * Gets the ticket with the specified ID from the queue
     * @param id the ID of the ticket to be retrieved
     * @return the ticket with the specified ID
     */
    public Ticket get(int id) throws Exception {
        // Validation
        ensureQueueIsNotEmpty();
        ensureIdExists(id);

        // Ge the priority from the ID -> Priority map
        int priority = _idMap.get(id);

        // Get the index for that priority
        int idx = getPriorityIndex(priority);

        // Return teh ticket details
        return new Ticket(id, priority, idx + 1);
    }

    /*
     * Private methods
     */

    /**
     * Gets the index of where the specified priority should belong in the
     * queue. Note: it does not evaluate whether the priority actually exists--
     * just tells you where it should exist.
     * @param priority the priority to locate the index for
     * @return the index in the queue of the specified priority
     */
    private int getPriorityIndex(int priority) {
        // Call on the overload using the queue bounds
        return getPriorityIndex(priority, 0, _tickets.size() - 1);
    }

    /**
     * Gets the index of where the specified priority should belong in the
     * range of the queue specified by the index arguments. Note:
     * it does not evaluate whether the priority actually exists--
     * just tells you where it should exist. The indices passed in
     * are inclusive and corelate to tHE conceptual subtree nodes
     * of the BST in the queue.
     * @param priority the priority to locate the index for
     * @param idxLo the lower bound index (inclusie) to query
     * @param idxHi the upper bound index (inclusie) to query
     * @return the index in the queue of the specified priority
     */
    private int getPriorityIndex(int priority, int idxLo, int idxHi) {
        if (idxHi - idxLo == 1) {
            // These are adjacent nodes
            return getPriorityIdxFromAdjacent(priority, idxLo, idxHi);
        }

        // These are a subtree (maybe even consisting of one node)
        return getPriorityIdxFromSubtree(priority, idxLo, idxHi);
    }

    /**
     * Gets the index of where the specified priority should belong in the
     * range of the queue specified by the index arguments. Note:
     * it does not evaluate whether the priority actually exists--
     * just tells you where it should exist. The indices passed in
     * are inclusive and corelate to the conceptual subtree nodes
     * of the BST in the queue. In this case, the indicies are expected
     * to be adjacent. For performance reasons, this bounds checking is not
     * performed, however.
     * @param priority the priority to locate the index for
     * @param idxLo the lower bound index (inclusie) to query
     * @param idxHi the upper bound index (inclusie) to query
     * @return the index in the queue of the specified priority
     */
    private int getPriorityIdxFromAdjacent(int p, int idxLo, int idxHi) {
        // Check against the lower node (higher priority)
        int higherPriority = _tickets.get(idxLo);
        if (p >= higherPriority) {
            // Matches or should prepend this node
            return idxLo;
        }

        // Check against the higher node (lower priority)
        int lowerPriority = _tickets.get(idxHi);
        if (p >= lowerPriority) {
            // Matches or should prepend this node
            // in other words, in between the adjacent nodes
            return idxHi;
        }

        // If we've gotten this far, then this belongs appended to
        // the higher node (lower priority)
        return idxHi + 1;
    }

    /**
     * Gets the index of where the specified priority should belong in the
     * range of the queue specified by the index arguments. Note:
     * it does not evaluate whether the priority actually exists--
     * just tells you where it should exist. The indices passed in
     * are inclusive and corelate to the conceptual subtree nodes
     * of the BST in the queue. In this case, the indicies are expected
     * to correspond to a subtree (perhaps a single node subtree).
     * @param priority the priority to locate the index for
     * @param idxLo the lower bound index (inclusie) to query
     * @param idxHi the upper bound index (inclusie) to query
     * @return the index in the queue of the specified priority
     */
    private int getPriorityIdxFromSubtree(int priority, int idxLo, int idxHi) {
        // Get the difference between the nodes
        int idxDiff = idxHi - idxLo;

        // Get the middle (parent) node index
        int compIdx = idxLo + (idxDiff / 2);

        // Get the middle (parent) node priority for comparison
        int compPriority = _tickets.get(compIdx);

        // Check for a priority match
        if (priority == compPriority) {
            // This node matches priority.
            // We've found our guy right where we wanted him to be...
            return compIdx;
        }

        // Check to see if the priority is higher than the middle (parent) node
        if (priority > compPriority) {
            // It is higher priority than the middle (parent) node
            if (idxDiff == 0) {
                // Single node comparison. This priority should be prepended
                // to this comparison node.
                return compIdx;
            }

            // This node belongs somewhere farther up the line;
            // go down another level left
            return getPriorityIndex(priority, idxLo, compIdx - 1);
        }

        // If we've gotten this far, the priority must be
        // lower than the middle (parent) node
        if (idxDiff == 0) {
            // Single node comparison. This priority should be appended
            // to this comparison node.
            return compIdx + 1;
        }

        // This node belongs somewhere farther down the line;
        // go down another level right
        return getPriorityIndex(priority, compIdx, idxHi);
    }

    /**
     * Ensures that the queue is not empty.
     * Throws an exception if it is.
     */
    private void ensureQueueIsNotEmpty() throws Exception {
        if (_tickets.isEmpty()) {
            errorEmptyQueue();
        }
    }

    /**
     * Ensures that the specified ID exists in the ID -> priority map.
     * Throws an exception if it doesn't.
     * @param id the ID to query
     */
    private void ensureIdExists(int id) throws Exception {
        if (!_idMap.containsKey(id)) {
            errorIdDoesNotExist(id);
        }
    }

    /**
     * Throws an error indicating that the removal failed due to the
     * empty queue
     */
    private void errorEmptyQueue() throws Exception {
        throw new Exception("removal attempted when queue is empty");
    }

    /**
     * Throws an error indicating that the specified priority
     * already exists in the queue
     * @param p the duplicate priority
     */
    private void errorDuplicatePriority(int p) throws Exception {
        throw new Exception("a ticket with priority " + p
                                                  + " is already in the queue");
    }

    /**
     * Throws an error indicating that the specified ID
     * does not exist in the queue
     * @param id the ID to query
     */
    private void errorIdDoesNotExist(int id) throws Exception {
        throw new Exception("there is no ticket with id = " + id
                                                             + " in the queue");
    }
}

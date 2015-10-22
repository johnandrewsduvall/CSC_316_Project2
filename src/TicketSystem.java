import java.util.*;

public class TicketSystem {
    private TreeMap<Integer, ArrayList<Integer>> _treeMap;
    public int maxID;

    public TicketSystem() {
        _treeMap = new TreeMap<Integer, ArrayList<Integer>>();
    }

    public int addTicket(int priority) {
        if (!_treeMap.containsKey(priority)) {
            _treeMap.put(priority, new ArrayList<Integer>());
        }
        int id = ++maxID;
        _treeMap.get(priority).add(id);
        return id;
    }
}
/**
 * @author Shujun Ye
 */
public class RemoveHighestCommandResult extends CommandResult {
    private int id;
    private int priority;
    public RemoveHighestCommandResult (int id, int priority){
        this.id = id;
        this.priority = priority;
    }
    public String print() {
        return "\tid = " + this.id + ", " + this.priority;
    }
}
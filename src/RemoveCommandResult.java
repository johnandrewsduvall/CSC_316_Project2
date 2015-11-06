/**
 * @author Shujun Ye
 */
public class RemoveCommandResult extends CommandResult {
    private int priority;
    private int position;
    public RemoveCommandResult(int priority, int position){
        this.priority = priority;
        this.position = position;
    }
    public String print() {
        return this.priority + ", pos = " + position;
    }
}
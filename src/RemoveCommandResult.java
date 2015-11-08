/**
 * @author Shujun Ye
 */
public class RemoveCommandResult extends CommandResult {
    private long priority;
    private long position;
    public RemoveCommandResult(long priority, long position){
        this.priority = priority;
        this.position = position;
    }
    @Override
    public String print() {
        return this.priority + ", pos = " + position;
    }
}

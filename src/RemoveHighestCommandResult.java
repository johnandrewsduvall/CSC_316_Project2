/**
 * @author Shujun Ye
 */
public class RemoveHighestCommandResult extends CommandResult {
    private long id;
    private long priority;
    public RemoveHighestCommandResult (long id, long priority){
        this.id = id;
        this.priority = priority;
    }
    @Override
    //Formats Ticket data into human readable string
    public String print() {
        return "id = " + this.id + ", " + this.priority;
    }
}

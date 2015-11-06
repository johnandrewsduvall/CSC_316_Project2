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
    @Override
    //Formats Ticket data into human readable string
    public String print() {
        return "id = " + this.id + ", " + this.priority;
    }
}

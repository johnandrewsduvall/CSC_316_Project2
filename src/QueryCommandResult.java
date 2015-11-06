/**
 * @author Shujun Ye
 */
public class QueryCommandResult extends CommandResult {
    private int position;
    public QueryCommandResult(int position) throws Exception{
        this.position = position;
    }
    public String print() {
        return "\tpos = " + this.position;
    }
}
/**
 * @author Shujun Ye
 */
public class QueryCommandResult extends CommandResult {
    private long position;
    public QueryCommandResult(long position) throws Exception{
        this.position = position;
    }
    public String print() {
        return "pos = " + this.position;
    }
}
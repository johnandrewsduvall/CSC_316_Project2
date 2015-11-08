/**
 * @author Shujun Ye
 */
public class QueryCommandResult extends CommandResult {
    private int position;
    public QueryCommandResult(int position) {
        this.position = position;
    }
    public String print() {
        return "pos = " + this.position;
    }
}
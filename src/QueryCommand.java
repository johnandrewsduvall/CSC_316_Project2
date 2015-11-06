/**
 * @author Shujun Ye
 */
public class QueryCommand extends Command<QueryCommandResult> {
    private int id;
    public QueryCommand (int id){
        this.id = id;
    }
    public QueryCommandResult run(TicketSystem ticketSystem) throws Exception{
        return new QueryCommandResult(ticketSystem.getPositionByID(this.id));
    }
}
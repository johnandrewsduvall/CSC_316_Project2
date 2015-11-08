/**
 * @author Shujun Ye
 */
public class QueryCommand extends Command<QueryCommandResult> {
    private long id;
    public QueryCommand (long id){
        this.id = id;
    }
    
    @Override
    public QueryCommandResult run(TicketSystem ticketSystem) throws Exception{
        return new QueryCommandResult(ticketSystem.getPositionByID(this.id));
    }
}
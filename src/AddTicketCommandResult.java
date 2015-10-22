public class AddTicketCommandResult extends CommandResult {
    private int id;
    
    public AddTicketCommandResult(int id) {
        this.id = id;
    }

    public String print() {
        return "id = " + id;
    }
}
public class AddCommandResult extends CommandResult {
    public long id;

    public AddCommandResult(long id) {
        this.id = id;
    }

    public String print() {
        return "id = " + id;
    }
}
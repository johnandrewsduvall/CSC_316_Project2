public class AddCommandResult extends CommandResult {
    public int id;

    public AddCommandResult(int id) {
        this.id = id;
    }

    public String print() {
        return "id = " + id;
    }
}
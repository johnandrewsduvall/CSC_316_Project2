public class AddCommandResult extends CommandResult {
    private int id;

    public AddCommandResult(int id) {
        this.id = id;
    }

    public String print() {
        return "id = " + id;
    }
}
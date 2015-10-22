import java.util.*;

public class CommandParser {
    public Command parseLine(String line) {
        if (line != null && line.length() > 0) {
            line = line.trim();
            if (line.length() > 0) {
                char action = line.charAt(0);
                switch (action) {
                    case '+':
                        return createAddTicketCommand(line);
                    default:
                        // Do nothing
                }
            }
        }

        return null;
    }

    private AddTicketCommand createAddTicketCommand(String line) {
        AddTicketCommand cmd = new AddTicketCommand();
        cmd.priority = new Scanner(line.substring(1)).nextInt();
        return cmd;
    }
}
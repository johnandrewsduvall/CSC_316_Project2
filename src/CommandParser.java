import java.util.*;

public class CommandParser {
    public Command parseLine(String line) {
        if (line != null && line.length() > 0) {
            line = line.trim();
            if (line.length() > 0) {
                char action = line.charAt(0);
                switch (action) {
                    case '+':
                        return parseAddCommand(line);
                    case '-':
                        return parseRemoveCommand(line);
                    case '*':
                        return parseRemoveHighestCommand();
                    case '?':
                        return parseQueryCommand(line);
                    default:
                        // Do nothing
                }
            }
        }

        return null;
    }

    private AddCommand parseAddCommand(String line) {
        int priority = new Scanner(line.substring(1)).nextInt();
        return new AddCommand(priority);
    }

    private RemoveCommand parseRemoveCommand(String line) {
        // TODO: Write this
        return null;
    }

    private RemoveHighestCommand parseRemoveHighestCommand() {
        // TODO: Write this
        return null;
    }

    private QueryCommand parseQueryCommand(String line) {
        // TODO: Write this
        return null;
    }
}
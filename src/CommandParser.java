import java.util.*;

public class CommandParser {
    public Command parseLine(String line) throws Exception {
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
                        // Fall through to exception line below
                }
            }
        }

        // Bad input
        throw new Exception("invalid command " + line);
    }

    private AddCommand parseAddCommand(String line) {
        int priority = new Scanner(line.substring(1)).nextInt();
        return new AddCommand(priority);
        // TODO: Detect non-parsable ID and
        // throw new Exception("id id is not an integer");
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
import java.util.*;
/**
 * @author Matthew Watkins
 * @author Shujun Ye
 */
public class CommandParser {
    public Command parseLine(String line) throws Exception {
        if (line != null && line.length() > 0) {
            line = line.trim();
            if (line.length() > 0) {
                char action = line.charAt(0);
                switch (action) {
                    case '+':
                        return parseAddCommand(line);
                    case '−':
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
        long priority = new Scanner(line.substring(1)).nextLong();
        return new AddCommand(priority);
    }

    private RemoveCommand parseRemoveCommand(String line) {
        long id = new Scanner(line.substring(1)).nextLong();
        return new RemoveCommand(id);
    }

    private RemoveHighestCommand parseRemoveHighestCommand() {
        return new RemoveHighestCommand();
    }

    private QueryCommand parseQueryCommand(String line) {
        long id = new Scanner(line.substring(1)).nextLong();
        return new QueryCommand(id);
    }
}
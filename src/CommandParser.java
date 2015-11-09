/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */
import java.util.*;

/**
 * The parsing class for the project.
 * @author Matthew Watkins
 * @author Shujun Ye
 */
public class CommandParser {
    /**
     * This class inputs and outputs of the program.
     * @param line input command string
     * @return input and output of the program.
     * @throws Exception if the input is invalid.
     */
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

    /**
     * This class parses AddCommand class.
     * @param line input command string
     * @return a ticket with the given priority.
     */
    private AddCommand parseAddCommand(String line) {
        long priority = new Scanner(line.substring(1)).nextLong();
        return new AddCommand(priority);
    }

    /**
     * This class parses RemoveCommand class.
     * @param line input command string
     * @return remvoves a ticket with the given id
     */
    private RemoveCommand parseRemoveCommand(String line) {
        long id = new Scanner(line.substring(1)).nextLong();
        return new RemoveCommand(id);
    }
    
    /**
     * This class parses RemoveHighestCommand class.
     * @return removes the ticket with the highest prioripty.
     */
    private RemoveHighestCommand parseRemoveHighestCommand() {
        return new RemoveHighestCommand();
    }

    /**
     * This class parses QueryCommand class.
     * @param line input command string
     * @return current position in the queue of the ticket the given id.
     */
    private QueryCommand parseQueryCommand(String line) {
        long id = new Scanner(line.substring(1)).nextLong();
        return new QueryCommand(id);
    }
}
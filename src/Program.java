/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */
import java.util.Scanner;

/**
 * This class handles error messages.
 * @author Matthew Watkins
 * @author Shujun Ye
 * @author John Andrew Duvall
 */
public class Program {
    /**
     * This method runs the program.
     */
    public static void run() {
        // Object initialization
        CommandParser cmdParser = new CommandParser();
        TicketSystem ticketSystem = new TicketSystem();
        Scanner scanner = new Scanner(System.in);

        //Main program loop
        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            System.out.println(inputLine);
            try {
                Command command = cmdParser.parseLine(inputLine);
                CommandResult commandResult = command.run(ticketSystem);
                System.out.println(commandResult.print());
            } catch (Exception e) {
                System.out.println(printError(e.getMessage()));
            }
        }
    }

    /**
     * This method format error message.
     * @param errorMessage a string of error message
     * @return a string of error message
     */
    private static String printError(String errorMessage) {
        return "Warning: " + errorMessage;
    }
}

/**
 * @author Matthew Watkins
 * @author Shujun Ye
 * @author John Andrew Duvall
 */

import java.util.Scanner;

public class HelpTickets {
    public static void main(String[] args) {

        //Object initialization
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

    //Formatting method
    private static String printError(String errorMessage) {
        return "Warning: " + errorMessage;
    }
}

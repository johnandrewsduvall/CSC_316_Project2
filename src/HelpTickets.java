import java.util.Scanner;

public class HelpTickets {
    public static void main(String[] args) {
        CommandParser cmdParser = new CommandParser();
        TicketSystem ticketSystem = new TicketSystem();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            System.out.println(inputLine);
            Command command = cmdParser.parseLine(inputLine);
            if (command == null) {
                System.out.println(printError("invalid command " + inputLine));
            } else {
                CommandResult commandResult = command.execute(ticketSystem);
                if (!commandResult.success) {
                    System.out.println(printError(commandResult.errorMessage));
                } else {
                    System.out.println(commandResult.print());
                }
            }
        }
    }

    private static String printError(String errorMessage) {
        return "Warning: " + errorMessage;
    }
}
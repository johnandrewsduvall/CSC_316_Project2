import java.util.Scanner;

public class HelpTickets {
    public static void main(String[] args) {
        CommandParser cmdParser = new CommandParser();
        TicketSystem ticketSystem = new TicketSystem();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            System.out.println(inputLine);
            try {
                Command command = cmdParser.parseLine(inputLine);
                CommandResult commandResult = command.run(ticketSystem);
                System.out.println('\t' + commandResult.print());
            } catch (Exception e) {
                System.out.println('\t' + printError(e.getMessage()));
            }
        }
    }

    private static String printError(String errorMessage) {
        return "Warning: " + errorMessage;
    }
}
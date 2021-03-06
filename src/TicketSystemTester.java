/**
 * Author:     John Andrew S Duvall, Matthew Watkins, Shujun Ye
 * Date:       08 Nov 2015
 * Project:    CSC 316 Project2
 */

import java.util.Scanner;

/**
 * This file tests the help ticket program with simulated input.
 * @author John Andrew S Duvall
 * @author Matthew Watkins
 * @author Shujun Ye
 */
public class TicketSystemTester {
    /**
     * Main method of the class.
     * @param args command line arguments.
     */
    public static void main (String[] args) {
        if (args != null && args.length > 0 && args[0].trim().equals("go")) {
            runTests();
            return;
        }
        TicketSystem ts = new TicketSystem();

        Ticket ticket = null;
        try {
            ticket = ts.add(10);
            testEquals(1, ticket.id);
            testEquals(1, ticket.position);
            testEquals(10, ticket.priority);
        } catch (Exception exception) {
            log(exception.getMessage());
        }

        try {
            ticket = ts.add(100);
            testEquals(2, ticket.id);
            testEquals(1, ticket.position);
            testEquals(100, ticket.priority);
        } catch (Exception exception) {
            log(exception.getMessage());
        }

        try {
            ticket = ts.add(50);
            testEquals(3, ticket.id);
            testEquals(2, ticket.position);
            testEquals(50, ticket.priority);
        } catch (Exception exception) {
            log(exception.getMessage());
        }

        try {
            ticket = ts.get(1);
            testEquals(1, ticket.id);
            testEquals(3, ticket.position);
            testEquals(10, ticket.priority);
        } catch (Exception exception) {
            log(exception.getMessage());
        }

        try {
            ticket = ts.remove(2);
            testEquals(2, ticket.id);
            testEquals(1, ticket.position);
            testEquals(100, ticket.priority);
        } catch (Exception exception) {
            log(exception.getMessage());
        }

        try {
            ticket = ts.removeHighest();
            testEquals(3, ticket.id);
            testEquals(1, ticket.position);
            testEquals(50, ticket.priority);
        } catch (Exception exception) {
            log(exception.getMessage());
        }

        try {
            ticket = ts.get(1);
            testEquals(1, ticket.id);
            testEquals(1, ticket.position);
            testEquals(10, ticket.priority);
        } catch (Exception exception) {
            log(exception.getMessage());
        }

        try {
            ticket = ts.removeHighest();
            testEquals(1, ticket.id);
            testEquals(1, ticket.position);
            testEquals(10, ticket.priority);
        } catch (Exception exception) {
            log(exception.getMessage());
        }

        log("All tests passed");
    }

    /**
     * This method runs from user prompt.
     */
    private static void runFromUserPrompt() {
        Scanner in = new Scanner(System.in);
        log("Help Tickets Tester");
        String choice = "y";

        while(!choice.equalsIgnoreCase("n"))
        {
            System.out.print("Automatic test or manual entry? (a/m): ");
            choice = in.nextLine();


            if(choice.equalsIgnoreCase("a"))
            {
                try {
                    runTests();
                } catch (Exception e) {
                    log(e.getMessage());
                }
            }
            else if (choice.equalsIgnoreCase("m") )
            {
                HelpTickets.main(null);
            }
            else
            {
                log("Invalid command");
            }
            System.out.print("Continue testing? (y/n) :");
            choice = in.nextLine();
        }
    }
    
    /**
     * This method run a series of tests.
     */
    private static void runTests() {
        TicketSystem ticketSystem = new TicketSystem();
        long failedTests = 0;
        Ticket ticket;
        try{
        //Attempt to remove ticket from empty list, tests failsafe condition
        log("TEST: Attempting to remove ticket from empty list (should fail)");
        ticketSystem.removeHighest();
        }
        catch(Exception e)
        {
            log(e.getMessage());
        }


            try {
// Add a ticket, should succeed
            log("TEST: Adding a ticket with priority 10");
            ticket = ticketSystem.add(10);
            failedTests += testEquals(1, ticket.id) ? 0 : 1;
            failedTests += testEquals(10, ticket.priority) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++;
        }

            try {
// Add another, should succeed
            log("TEST: Adding a ticket with priority 100");
            ticket = ticketSystem.add(100);
            failedTests += testEquals(2, ticket.id) ? 0 : 1;
            failedTests += testEquals(100, ticket.priority) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++;
        }

            try {
// And another, should succeed
            log("TEST: Adding a ticket with priority 50");
            ticket = ticketSystem.add(50);
            log("   Validating ticket ID");
            failedTests += testEquals(3, ticket.id) ? 0 : 1;
            log("   Validating ticket priority");
            failedTests += testEquals(50, ticket.priority) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++;
        }

            try {
            log("TEST: Querying the position of ticket ID 1");
            failedTests += testEquals(3, ticketSystem.get(1)) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++;
        }

            try {
            log("TEST: Removing the ticket with ID 2");
            ticket = ticketSystem.remove(2);
            log("   Validating ticket ID");
            failedTests += testEquals(2, ticket.id) ? 0 : 1;
            log("   Validating ticket priority");
            failedTests += testEquals(100, ticket.priority) ? 0 : 1;
            log("   Validating ticket position");
            failedTests += testEquals(1, ticket.position) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++;
        }

            try {
            log("TEST: Querying the position of ticket ID 1 again");
            failedTests += testEquals(2, ticketSystem.get(1)) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++;
        }
            try {
            log("TEST: Querying the position of ticket ID 3");
            failedTests += testEquals(1, ticketSystem.get(3)) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++;
        }

            try {
            log("TEST: Removing the highest priority ticket");
            ticket = ticketSystem.removeHighest();
            log("   Validating ticket ID");
            failedTests += testEquals(3, ticket.id) ? 0 : 1;
            log("   Validating ticket priority");
            failedTests += testEquals(50, ticket.priority) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++;
        }

            try {
            log("TEST: Querying the position of ticket ID 1 yet again");
            failedTests += testEquals(1, ticketSystem.get(1)) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++;
        }

            try {
            log("TEST: Removing the highest priority ticket");
            ticket = ticketSystem.removeHighest();
            log("   Validating ticket ID");
            failedTests += testEquals(1, ticket.id) ? 0 : 1;
            log("   Validating ticket priority");
            failedTests += testEquals(10, ticket.priority) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++;
        }

            if(failedTests == 0)
            {
                log("All tests passed");
            }
            else
            {
                log("WARNING FAILED " + failedTests + " TESTS");
            }

    }
    
    /**
     * This method tests if two objects are equal.
     * @return return true if two are equal, false otherwise.
     */
    private static boolean testEquals(Object expected, Object actual)
                                                            throws Exception {
        test(expected.equals(actual), "Expected " + expected.toString()
                                            + " but got " + actual.toString());
        return expected.toString().equals(actual.toString());
    }
    
    /**
     * This method tests the error message.
     */
    private static void test(boolean check, String message) throws Exception {
        if (!check) {
            throw new Exception(message);
        }
    }

    /**
     * Local Print message to improve readability of code
     */
    private static void log(String message) {
        System.out.println(message);
    }
}

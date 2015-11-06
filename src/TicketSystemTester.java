/**
 * @author Matthew Watkins, Shujun Ye, John Andrew Duvall
 * This file tests the help ticket program with simulated input.
 */


public class TicketSystemTester {
    public static void main (String[] args) {

        try {
            runTests();
        } catch (Exception e) {
            log(e.getMessage());
        }
        
    }

    private static void runTests() {
        TicketSystem ticketSystem = new TicketSystem();
        int failedTests = 0;
        Ticket ticket;
        try{
        //Attempt to remove ticket from empty list, tests failsafe condition
        log("TEST: Attempting to remove ticket from empty list (should fail)");
        ticketSystem.removeHighest(true);
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
            failedTests += testEquals(3, ticketSystem.getPositionByID(1)) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++; 
        }

            try {
            log("TEST: Removing the ticket with ID 2");
            ticket = ticketSystem.removeID(2, true);
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
            failedTests += testEquals(2, ticketSystem.getPositionByID(1)) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++; 
        }
            try {
            log("TEST: Querying the position of ticket ID 3");
            failedTests += testEquals(1, ticketSystem.getPositionByID(3)) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++; 
        }

            try {
            log("TEST: Removing the highest priority ticket");
            ticket = ticketSystem.removeHighest(false);
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
            failedTests += testEquals(1, ticketSystem.getPositionByID(1)) ? 0 : 1;
        } catch (Exception exception) {
            log(exception.getMessage());
            failedTests++; 
        }

            try {
            log("TEST: Removing the highest priority ticket");
            ticket = ticketSystem.removeHighest(false);
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
    private static boolean testEquals(Object expected, Object actual) 
                                                            throws Exception {
        test(expected.equals(actual), "Expected " + expected.toString() 
                                            + " but got " + actual.toString());
        return expected.toString().equals(actual.toString());
    }

    private static void test(boolean check, String message) throws Exception {
        if (!check) {
            throw new Exception(message);
        }
    }

    //Local Print message to improve readability of code
    private static void log(String message) {
        System.out.println(message);
    }
}
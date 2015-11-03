public class TicketSystemTester {
    public static void main (String[] args) {
        try {
            runTests();
        } catch (Exception e) {
            log(e.getMessage());
        }
    }

    private static void runTests() throws Exception {
        TicketSystem ticketSystem = new TicketSystem();

        // Add a ticket
        log("TEST: Adding a ticket with priority 10");
        Ticket ticket = ticketSystem.add(10);
        testEquals(1, ticket.id);
        testEquals(10, ticket.priority);

        // Add another
        log("TEST: Adding a ticket with priority 100");
        ticket = ticketSystem.add(100);
        testEquals(2, ticket.id);
        testEquals(100, ticket.priority);

        // And another
        log("TEST: Adding a ticket with priority 50");
        ticket = ticketSystem.add(50);
        log("   Validating ticket ID");
        testEquals(3, ticket.id);
        log("   Validating ticket priority");
        testEquals(50, ticket.priority);

        log("TEST: Querying the position of ticket ID 1");
        testEquals(3, ticketSystem.getPositionByID(1));

        log("TEST: Removing the ticket with ID 2");
        ticket = ticketSystem.removeID(2, true);
        log("   Validating ticket ID");
        testEquals(2, ticket.id);
        log("   Validating ticket priority");
        testEquals(100, ticket.priority);
        log("   Validating ticket position");
        testEquals(1, ticket.position);

        log("TEST: Querying the position of ticket ID 1 again");
        testEquals(2, ticketSystem.getPositionByID(1));

        log("TEST: Querying the position of ticket ID 3");
        testEquals(1, ticketSystem.getPositionByID(3));

        log("TEST: Removing the highest priority ticket");
        ticket = ticketSystem.removeHighest(false);
        log("   Validating ticket ID");
        testEquals(3, ticket.id);
        log("   Validating ticket priority");
        testEquals(50, ticket.priority);

        log("TEST: Querying the position of ticket ID 1 yet again");
        testEquals(1, ticketSystem.getPositionByID(1));

        log("TEST: Removing the highest priority ticket");
        ticket = ticketSystem.removeHighest(false);
        log("   Validating ticket ID");
        testEquals(1, ticket.id);
        log("   Validating ticket priority");
        testEquals(10, ticket.priority);

        log("All tests passed");
    }

    private static void testEquals(Object expected, Object actual) throws Exception {
        test(expected.equals(actual), "Expected " + expected.toString() + " but got " + actual.toString());
    }

    private static void test(boolean check, String message) throws Exception {
        if (!check) {
            throw new Exception(message);
        }
    }

    private static void log(String message) {
        System.out.println(message);
    }
}
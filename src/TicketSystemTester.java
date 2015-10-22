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
        log("Adding a ticket with priority 10");
        Ticket ticket = ticketSystem.addTicket(10);
        testEquals(1, ticket.id);
        testEquals(10, ticket.priority);

        // Add another
        log("Adding a ticket with priority 100");
        ticket = ticketSystem.addTicket(100);
        testEquals(2, ticket.id);
        testEquals(100, ticket.priority);

        // And another
        log("Adding a ticket with priority 50");
        ticket = ticketSystem.addTicket(50);
        testEquals(3, ticket.id);
        testEquals(50, ticket.priority);

        log("Querying the position of ticket ID 1");
        testEquals(3, ticketSystem.getTicketQueuePosition(1));

        log("Removing the ticket with ID 2");
        ticket = ticketSystem.removeTicket(2);
        testEquals(100, ticket.priority);
        testEquals(2, ticket.id);
        testEquals(1, ticket.position);

        log("Querying the position of ticket ID 1 again");
        testEquals(2, ticketSystem.getTicketQueuePosition(1));

        log("Querying the position of ticket ID 3");
        testEquals(1, ticketSystem.getTicketQueuePosition(3));

        log("Removing the highest priority ticket");
        ticket = ticketSystem.removeHighestPriorityTicket();
        testEquals(50, ticket.priority);
        testEquals(3, ticket.id);

        log("Querying the position of ticket ID 1 yet again");
        testEquals(1, ticketSystem.getTicketQueuePosition(1));

        log("Removing the highest priority ticket");
        ticket = ticketSystem.removeHighestPriorityTicket();
        testEquals(10, ticket.priority);
        testEquals(1, ticket.id);

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
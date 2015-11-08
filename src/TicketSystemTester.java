public class TicketSystemTester {
    public static void main(String[] args) throws Exception {
        TicketSystem ts = new TicketSystem();

        Ticket ticket = ts.add(10);
        testEquals(1, ticket.id);
        testEquals(1, ticket.position);
        testEquals(10, ticket.priority);

        ticket = ts.add(100);
        testEquals(2, ticket.id);
        testEquals(1, ticket.position);
        testEquals(100, ticket.priority);

        ticket = ts.add(50);
        testEquals(3, ticket.id);
        testEquals(2, ticket.position);
        testEquals(50, ticket.priority);

        ticket = ts.get(1);
        testEquals(1, ticket.id);
        testEquals(3, ticket.position);
        testEquals(10, ticket.priority);

        ticket = ts.remove(2);
        testEquals(2, ticket.id);
        testEquals(1, ticket.position);
        testEquals(100, ticket.priority);

        ticket = ts.removeHighest();
        testEquals(3, ticket.id);
        testEquals(1, ticket.position);
        testEquals(50, ticket.priority);

        ticket = ts.get(1);
        testEquals(1, ticket.id);
        testEquals(1, ticket.position);
        testEquals(10, ticket.priority);

        ticket = ts.removeHighest();
        testEquals(1, ticket.id);
        testEquals(1, ticket.position);
        testEquals(10, ticket.priority);

        log("All tests passed");
    }

    private static boolean testEquals(Object expected, Object actual) throws Exception {
        test(expected.equals(actual), "Expected " + expected.toString() + " but got " + actual.toString());
        return expected.toString().equals(actual.toString());
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
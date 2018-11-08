package complex.algo.squarespace;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A ticket-reservation system which can manage the reservation of tickets for events.
 */
public class TicketReservationSystem {
    private final Event event;
    private final TicketPrinter printer;

    private int atomicSerial;
    private ReentrantLock lock;
    private int currentCapacity;
    private Map<String, Integer> tickesPerAccount;

    /**
     * Create a new {@code TicketReservationSystem} to reserve tickets for the specified event.
     */
    public TicketReservationSystem(Event event, TicketPrinter printer) {
        this.event = event;
        this.printer = printer;
        this.currentCapacity = this.event.capacity;
        this.atomicSerial = 1;
        this.lock = new ReentrantLock();
        this.tickesPerAccount = new ConcurrentHashMap<>();

//        System.out.println(String.format("Reserved %d tickets in total", this.currentCapacity));
    }

    /**
     * Attempts to reserve a ticket to the specified {@code event} for the account associated with the specified {@code
     * accountId}. This implementation must be thread-safe.
     *
     * @return a ticket if and only if there are tickets available and the account has not hit its ticket limit.
     */
    public Optional<Ticket> reserveTicket(String accountId) {
        // TODO: Implement this method. See `TicketPrinter::printTicket` and the fields of `Event` below.
        Optional<Ticket> ticket = Optional.empty();
        lock.lock();
        if (this.currentCapacity > 0) {
            if (this.tickesPerAccount.containsKey(accountId)) {
                int ticketSold = this.tickesPerAccount.get(accountId);
                if (ticketSold < this.event.maxTicketsPerAccount) {
                    atomicSerial++;
                    ticket = Optional.of(this.printer.printTicket(this.event, accountId, atomicSerial));
                    ticketSold++;
                    this.tickesPerAccount.put(accountId, ticketSold);
                    this.currentCapacity--;
                }
            } else {
                atomicSerial++;
                ticket = Optional.of(this.printer.printTicket(this.event, accountId, atomicSerial));
                this.tickesPerAccount.put(accountId, 1);
                this.currentCapacity--;
            }
        }
        lock.unlock();
        // NOTE: Probably best to solve for serial execution first. Then thread-safety.
        // NOTE: A `synchronized` block or method can be used to lock a critical section.
        return ticket;
    }
    /// YOU CAN EDIT ANY CODE ABOVE THIS LINE ///

    static class Event {
        public final int capacity;
        public final int maxTicketsPerAccount;

        public Event(int capacity, int maxTicketsPerAccount) {
            this.capacity = capacity;
            this.maxTicketsPerAccount = maxTicketsPerAccount;
        }
    }

    static class TicketPrinter {
        public final int ticketPrintingTimeInMilliseconds;

        /**
         * Do not call this directly.
         */
        TicketPrinter(int ticketPrintingTimeInMilliseconds) {
            if (Thread.currentThread().getStackTrace().length > 3) {
                // This should in any normal environment be enforced through constructor visibility.
                throw new RuntimeException("attempt to create alternative ticket printer");
            }
            this.ticketPrintingTimeInMilliseconds = ticketPrintingTimeInMilliseconds;
        }

        public Ticket printTicket(Event event, String accountId, int serial) {
            if (ticketPrintingTimeInMilliseconds > 0) {
                try {
                    Thread.sleep(ticketPrintingTimeInMilliseconds); // Printing a ticket is a bit slow.
                } catch (InterruptedException e) {
                    // ...and ignore.
                }
            }
            return new Ticket(event, accountId, serial);
        }
    }

    /// TEST HARNESS BELOW THIS LINE ///

    public static void main(String args[]) throws Exception {
        Input input = Input.parse(System.in);
        Event event = new Event(input.eventCapacity, input.maxTicketsPerAccount);
        TicketReservationSystem boxOffice = new TicketReservationSystem(event, new TicketPrinter(input.ticketPrintingTimeInMilliseconds));
        Stream<String> reservationRequests;
        if (input.testMode.equals("serial")) {
            reservationRequests = input.reservationRequests.stream();
        } else if (input.testMode.equals("concurrent")) {
            reservationRequests = input.reservationRequests.parallelStream();
        } else {
            throw new RuntimeException("invalid execution mode: " + input.testMode);
        }
        long startTime = System.nanoTime();
        Collection<Ticket> reservations =
                reservationRequests
                        .map(boxOffice::reserveTicket)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());
        long endTime = System.nanoTime();
        int testRunTimeInMilliseconds = (int) (Duration.ofNanos(endTime - startTime).toMillis());
        Output output = Output.parse(reservations);
        if (input.testCase.equals("print output")) {
            output.print(System.out);
        } else {
            System.out.println(
                    String.format(
                            "%s test: %s for %s reservation requests.",
                            check(input, output, testRunTimeInMilliseconds) ? "Passed" : "Failed", input.testCase, input.testMode));
        }
    }

    static boolean check(Input input, Output output, int testRunTimeInMilliseconds) {
        switch (input.testCase) {
            case "total reservation count does not exceed event capacity":
                return output.reservationCount <= input.eventCapacity;
            case "reservations do not exceed per-account ticket limit":
                int limit = input.maxTicketsPerAccount;
                for (Integer numberOfTicketsReservedForAccount : output.reservationsMadeByAccount.values()) {
                    if (numberOfTicketsReservedForAccount > limit) {
                        return false;
                    }
                }
                return true;
            case "reservations were not made for account IDs not in input":
                for (String accountId : output.reservationsMadeByAccount.keySet()) {
                    if (!input.reservationRequestsByAccount.containsKey(accountId)) {
                        return false;
                    }
                }
                return true;
            case "reservations were not made for more tickets for any account than were requested by that account":
                for (Map.Entry<String, Integer> reservation : output.reservationsMadeByAccount.entrySet()) {
                    String accountId = reservation.getKey();
                    Integer ticketsReserved = reservation.getValue();
                    if (input.reservationRequestsByAccount.getOrDefault(accountId, 0) < ticketsReserved) {
                        return false;
                    }
                }
                return true;
            case "reservations were not made with duplicate ticket serial numbers":
                return output.serialNumbers.size() == output.reservationCount;
            case "reservation serial numbers cover [1, n]":
                for (int i = 1; i <= output.reservationCount; i++) {
                    if (!output.serialNumbers.contains(i)) {
                        return false;
                    }
                }
                return true;
            case "tickets have been reserved":
                return output.reservationCount > 0;
            case "speedup observed through concurrent invocation":
                return testRunTimeInMilliseconds < output.reservationCount * input.ticketPrintingTimeInMilliseconds;
            default:
                throw new RuntimeException("invalid test case: " + input.testCase);
        }
    }

    static class Ticket {
        public final Event event;
        public final String accountId;
        public final int serial;

        /**
         * Do not call this directly.
         */
        Ticket(Event event, String accountId, int serial) {
            String callerClass = Thread.currentThread().getStackTrace()[2].getClassName();
            if (!callerClass.equals(TicketPrinter.class.getName())) {
                // This should in any normal environment be enforced through constructor visibility.
                throw new RuntimeException("attempt to create ticket without printing it");
            }
            this.event = event;
            this.accountId = accountId;
            this.serial = serial;
        }
    }

    /**
     * Input format (on STDIN): <code>
     * [Test Mode ("serial" or "concurrent")]
     * [Test Case Description]
     * [Event Capacity]
     * [Maximum Number of Tickets Per Account]
     * [Time in milliseconds it takes to "print" a ticket]
     * [Number of Reservation Requests Pending]
     * [Pending Reservation Requests (for one ticket each), as Newline-Separated List of Account IDs]
     * </code> Example: <code>
     * concurrent
     * total reservation count does not exceed event capacity
     * 5
     * 2
     * 500
     * 8
     * Jane
     * George
     * George
     * George
     * George
     * Alice
     * Jane
     * Bob
     * </code>
     */
    static class Input {
        final String testMode;
        final String testCase;
        final int eventCapacity;
        final int maxTicketsPerAccount;
        final int ticketPrintingTimeInMilliseconds;
        final Collection<String> reservationRequests;
        final Map<String, Integer> reservationRequestsByAccount;

        Input(
                String testMode,
                String testCase,
                int eventCapacity,
                int maxTicketsPerAccount,
                int ticketPrintingTimeInMilliseconds,
                Collection<String> reservationRequests,
                Map<String, Integer> reservationRequestsByAccount) {
            this.testMode = testMode;
            this.testCase = testCase;
            this.eventCapacity = eventCapacity;
            this.maxTicketsPerAccount = maxTicketsPerAccount;
            this.ticketPrintingTimeInMilliseconds = ticketPrintingTimeInMilliseconds;
            this.reservationRequests = reservationRequests;
            this.reservationRequestsByAccount = reservationRequestsByAccount;
        }

        static Input parse(InputStream inputStream) {
            Scanner input = new Scanner(inputStream).useDelimiter("\n");
            String testMode = input.next();
            String testCase = input.next();
            int eventCapacity = input.nextInt();
            int maxTicketsPerAccount = input.nextInt();
            int ticketPrintingTimeInMilliseconds = input.nextInt();
            int reservationRequestCount = input.nextInt();
            Collection<String> reservationRequests = new ArrayList<>(eventCapacity);
            Map<String, Integer> reservationRequestsByAccount = new HashMap<>();
            for (int i = 0; i < reservationRequestCount; i++) {
                String accountId = input.next();
                reservationRequests.add(accountId);
                reservationRequestsByAccount.put(accountId, reservationRequestsByAccount.getOrDefault(accountId, 0) + 1);
            }
            return new Input(
                    testMode,
                    testCase,
                    eventCapacity,
                    maxTicketsPerAccount,
                    ticketPrintingTimeInMilliseconds,
                    reservationRequests,
                    reservationRequestsByAccount);
        }
    }

    static class Output {
        final int reservationCount;
        final Set<Integer> serialNumbers;
        final SortedMap<String, Integer> reservationsMadeByAccount;

        private Output(
                int reservationCount, Set<Integer> serialNumbers, SortedMap<String, Integer> reservationsMadeByAccount) {
            this.reservationCount = reservationCount;
            this.serialNumbers = serialNumbers;
            this.reservationsMadeByAccount = reservationsMadeByAccount;
        }

        public void print(PrintStream out) {
            out.printf("Reserved %s tickets in total%n", reservationCount);
            for (Map.Entry<String, Integer> entry : reservationsMadeByAccount.entrySet()) {
                out.printf("Reserved %s tickets for account %s%n", entry.getValue(), entry.getKey());
            }
        }

        static Output parse(Collection<Ticket> reservations) {
            int reservationCount = 0;
            Set<Integer> serialNumbers = new HashSet<>();
            SortedMap<String, Integer> reservationsMadeByAccount = new TreeMap<>();
            for (Ticket reservation : reservations) {
                reservationCount++;
                String accountId = reservation.accountId;
                Integer serial = reservation.serial;
                reservationsMadeByAccount.put(accountId, reservationsMadeByAccount.getOrDefault(accountId, 0) + 1);
                serialNumbers.add(serial);
            }
            return new Output(reservationCount, serialNumbers, reservationsMadeByAccount);
        }
    }
}


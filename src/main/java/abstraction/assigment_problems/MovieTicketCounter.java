package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

abstract class Ticket {
    // The convenience fee is written in exactly one place.
    private static final double CONVENIENCE_FEE = 20;

    private final int count;

    Ticket(int count) { this.count = count; }

    abstract String getSeatType();

    abstract double getPrice();

    double calculateAmount() { return count * (getPrice() + CONVENIENCE_FEE); }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) { super(count); }

    @Override String getSeatType() { return "REGULAR"; }

    @Override double getPrice() { return 150; }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) { super(count); }

    @Override String getSeatType() { return "PREMIUM"; }

    @Override double getPrice() { return 250; }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) { super(count); }

    @Override String getSeatType() { return "RECLINER"; }

    @Override double getPrice() { return 400; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();
            Ticket t;
            switch (seat) {
                case "REGULAR":  t = new RegularTicket(count); break;
                case "PREMIUM":  t = new PremiumTicket(count); break;
                case "RECLINER": t = new ReclinerTicket(count); break;
                default: throw new IllegalArgumentException("Unknown seat type: " + seat);
            }
            double amount = t.calculateAmount();
            total += amount;
            System.out.println(String.format(Locale.US, "%s: %.2f", t.getSeatType(), amount));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}

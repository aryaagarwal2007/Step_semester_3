package abstraction.class_problems;

import java.util.Locale;
import java.util.Scanner;

abstract class Booking {
    // The booking fee lives in exactly one place.
    private static final double BOOKING_FEE = 50;

    protected final double distanceKm;

    Booking(double distanceKm) { this.distanceKm = distanceKm; }

    abstract String getMode();

    abstract double calculateFare();

    final double calculateTotal() { return calculateFare() + BOOKING_FEE; }
}

class BusBooking extends Booking {
    BusBooking(double distanceKm) { super(distanceKm); }

    @Override String getMode() { return "BUS"; }

    @Override double calculateFare() { return 2.0 * distanceKm; }
}

class TrainBooking extends Booking {
    TrainBooking(double distanceKm) { super(distanceKm); }

    @Override String getMode() { return "TRAIN"; }

    @Override double calculateFare() { return 1.5 * distanceKm; }
}

class FlightBooking extends Booking {
    FlightBooking(double distanceKm) { super(distanceKm); }

    @Override String getMode() { return "FLIGHT"; }

    @Override double calculateFare() { return 2500 + 4.0 * distanceKm; }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double km = sc.nextDouble();
            Booking b;
            switch (mode) {
                case "BUS":    b = new BusBooking(km); break;
                case "TRAIN":  b = new TrainBooking(km); break;
                case "FLIGHT": b = new FlightBooking(km); break;
                default: throw new IllegalArgumentException("Unknown mode: " + mode);
            }
            System.out.println(String.format(Locale.US, "%s: %.2f", b.getMode(), b.calculateTotal()));
        }
    }
}

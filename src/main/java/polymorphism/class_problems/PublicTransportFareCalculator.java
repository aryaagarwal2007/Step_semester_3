package polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Practice 5: Public Transport Fare Calculator
 *
 * Transport is an abstract base type; each subclass overrides
 * calculateFare() with its own rule (including Bus's fare cap and
 * Metro's peak-hour multiplier). The main loop calls calculateFare()
 * uniformly on every Transport in the list.
 */
public class PublicTransportFareCalculator {

    static abstract class Transport {
        protected final String label;
        protected final double distance;

        Transport(String label, double distance) {
            this.label = label;
            this.distance = distance;
        }

        abstract double calculateFare();
    }

    static class Bus extends Transport {
        Bus(double distance) {
            super("BUS", distance);
        }

        double calculateFare() {
            double fare = 2 + 0.10 * distance;
            return Math.min(fare, 10);
        }
    }

    static class Train extends Transport {
        Train(double distance) {
            super("TRAIN", distance);
        }

        double calculateFare() {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro extends Transport {
        private final double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            super("METRO", distance);
            this.peakHourFactor = peakHourFactor;
        }

        double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            switch (type) {
                case "BUS":
                    journeys.add(new Bus(distance));
                    break;
                case "TRAIN":
                    journeys.add(new Train(distance));
                    break;
                case "METRO":
                    double peakHourFactor = Double.parseDouble(parts[2]);
                    journeys.add(new Metro(distance, peakHourFactor));
                    break;
                default:
                    System.out.println("Unknown transport type: " + type);
            }
        }

        double total = 0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            System.out.printf("%s: %.2f%n", t.label, fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

package polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Practice 3: Delivery Fee Calculator
 *
 * Delivery is an abstract base type; each subclass overrides
 * calculateFee() with its own pricing formula. The main loop calls
 * calculateFee() uniformly on every Delivery in the list.
 */
public class DeliveryFeeCalculator {

    static abstract class Delivery {
        protected final String label;
        protected final double weight;
        protected final double distance;

        Delivery(String label, double weight, double distance) {
            this.label = label;
            this.weight = weight;
            this.distance = distance;
        }

        abstract double calculateFee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double weight, double distance) {
            super("STANDARD", weight, distance);
        }

        double calculateFee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double weight, double distance) {
            super("EXPRESS", weight, distance);
        }

        double calculateFee() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }

    static class InternationalDelivery extends Delivery {
        private final double customsFee;

        InternationalDelivery(double weight, double distance, double customsFee) {
            super("INTERNATIONAL", weight, distance);
            this.customsFee = customsFee;
        }

        double calculateFee() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            switch (type) {
                case "STANDARD":
                    deliveries.add(new StandardDelivery(weight, distance));
                    break;
                case "EXPRESS":
                    deliveries.add(new ExpressDelivery(weight, distance));
                    break;
                case "INTERNATIONAL":
                    double customsFee = Double.parseDouble(parts[3]);
                    deliveries.add(new InternationalDelivery(weight, distance, customsFee));
                    break;
                default:
                    System.out.println("Unknown delivery type: " + type);
            }
        }

        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            System.out.printf("%s: %.2f%n", d.label, fee);
            total += fee;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

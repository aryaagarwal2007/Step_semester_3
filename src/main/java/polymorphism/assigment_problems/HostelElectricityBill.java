package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Assignment 3: The Hostel Electricity Bill
 *
 * Room is an abstract base type; each subclass overrides calculateBill()
 * with its own rule. SharedRoom carries the extra occupants value as its
 * own field, so the main loop can still treat every Room uniformly.
 */
public class HostelElectricityBill {

    static abstract class Room {
        protected final String label;
        protected final int units;

        Room(String label, int units) {
            this.label = label;
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super("SINGLE", units);
        }

        double calculateBill() {
            return units * 8.0;
        }
    }

    static class SharedRoom extends Room {
        private final int occupants;

        SharedRoom(int units, int occupants) {
            super("SHARED", units);
            this.occupants = occupants;
        }

        double calculateBill() {
            return (units * 6.0) / occupants;
        }
    }

    static class AcRoom extends Room {
        AcRoom(int units) {
            super("AC", units);
        }

        double calculateBill() {
            return units * 10.0 + 200.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;
                case "SHARED":
                    int occupants = Integer.parseInt(parts[2]);
                    rooms.add(new SharedRoom(units, occupants));
                    break;
                case "AC":
                    rooms.add(new AcRoom(units));
                    break;
                default:
                    System.out.println("Unknown room type: " + type);
            }
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            System.out.printf("%s: %.2f%n", r.label, bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

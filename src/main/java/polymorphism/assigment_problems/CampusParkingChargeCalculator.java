package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Assignment 2: The Campus Parking Charge Calculator
 *
 * Vehicle is an abstract base type; each subclass overrides
 * calculateCharge() with its own hourly rule (Car's first-hour rate,
 * Truck's minimum charge). The main loop calls calculateCharge()
 * uniformly on every Vehicle in the list.
 */
public class CampusParkingChargeCalculator {

    static abstract class Vehicle {
        protected final String label;
        protected final int hours;

        Vehicle(String label, int hours) {
            this.label = label;
            this.hours = hours;
        }

        abstract double calculateCharge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super("BIKE", hours);
        }

        double calculateCharge() {
            return 10.0 * hours;
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super("CAR", hours);
        }

        double calculateCharge() {
            if (hours <= 1) {
                return 30.0;
            }
            return 30.0 + 20.0 * (hours - 1);
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super("TRUCK", hours);
        }

        double calculateCharge() {
            return Math.max(50.0 * hours, 100.0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            switch (type) {
                case "BIKE":
                    vehicles.add(new Bike(hours));
                    break;
                case "CAR":
                    vehicles.add(new Car(hours));
                    break;
                case "TRUCK":
                    vehicles.add(new Truck(hours));
                    break;
                default:
                    System.out.println("Unknown vehicle type: " + type);
            }
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f%n", v.label, charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

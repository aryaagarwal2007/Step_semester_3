package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Assignment 1: The Canteen Billing Counter
 *
 * Customer is an abstract base type; each subclass overrides
 * getFinalAmount() with its own discount/surcharge rule. The billing loop
 * calls getFinalAmount() uniformly, without checking customer type.
 */
public class CanteenBillingCounter {

    static abstract class Customer {
        protected final String label;
        protected final double billAmount;

        Customer(String label, double billAmount) {
            this.label = label;
            this.billAmount = billAmount;
        }

        abstract double getFinalAmount();
    }

    static class StudentCustomer extends Customer {
        StudentCustomer(double billAmount) {
            super("STUDENT", billAmount);
        }

        double getFinalAmount() {
            return billAmount * 0.90;
        }
    }

    static class StaffCustomer extends Customer {
        StaffCustomer(double billAmount) {
            super("STAFF", billAmount);
        }

        double getFinalAmount() {
            return billAmount * 0.95;
        }
    }

    static class GuestCustomer extends Customer {
        GuestCustomer(double billAmount) {
            super("GUEST", billAmount);
        }

        double getFinalAmount() {
            return billAmount + 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            switch (type) {
                case "STUDENT":
                    bills.add(new StudentCustomer(amount));
                    break;
                case "STAFF":
                    bills.add(new StaffCustomer(amount));
                    break;
                case "GUEST":
                    bills.add(new GuestCustomer(amount));
                    break;
                default:
                    System.out.println("Unknown customer type: " + type);
            }
        }

        double total = 0;
        for (Customer c : bills) {
            double finalAmount = c.getFinalAmount();
            System.out.printf("%s: %.2f%n", c.label, finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

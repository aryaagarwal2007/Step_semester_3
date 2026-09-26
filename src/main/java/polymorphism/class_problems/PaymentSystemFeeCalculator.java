package polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Practice 1: Payment System Fee Calculation
 *
 * Payment is an abstract base type; each subclass overrides
 * getAdjustedAmount() with its own fee rule. The main loop just calls
 * getAdjustedAmount() on every Payment in the list — no type checking
 * happens outside the classes themselves.
 */
public class PaymentSystemFeeCalculator {

    static abstract class Payment {
        protected final String label;
        protected final double amount;

        Payment(String label, double amount) {
            this.label = label;
            this.amount = amount;
        }

        abstract double getAdjustedAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) {
            super("CARD", amount);
        }

        double getAdjustedAmount() {
            return amount * 1.02;
        }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) {
            super("WALLET", amount);
        }

        double getAdjustedAmount() {
            return amount * 1.01;
        }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) {
            super("BANKTRANSFER", amount);
        }

        double getAdjustedAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            switch (type) {
                case "CARD":
                    payments.add(new CardPayment(amount));
                    break;
                case "WALLET":
                    payments.add(new WalletPayment(amount));
                    break;
                case "BANKTRANSFER":
                    payments.add(new BankTransferPayment(amount));
                    break;
                default:
                    System.out.println("Unknown payment type: " + type);
            }
        }

        double total = 0;
        for (Payment p : payments) {
            double adjusted = p.getAdjustedAmount();
            System.out.printf("%s: %.2f%n", p.label, adjusted);
            total += adjusted;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

package encapsulation.class_problems;

/**
 * Practice 1: The Piggy Bank
 *
 * savings is private, changed only via deposit()/withdraw(). A withdrawal
 * bigger than current savings is rejected outright, leaving savings
 * unchanged. id is final, fixed at construction.
 */
public class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        savings += amount;
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdraw rejected: insufficient savings");
            return;
        }
        savings -= amount;
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("After deposit(100): " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After withdraw(30): " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("After withdraw(500) rejected: " + pb.getSavings());
    }
}

package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

// Ability: only some parcels can be insured.
interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected final double weightKg;
    protected final double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract String getType();

    abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }

    @Override String getType() { return "STANDARD"; }

    @Override double calculateCharge() { return 40 + 10 * weightKg; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }

    @Override String getType() { return "EXPRESS"; }

    @Override double calculateCharge() { return 80 + 15 * weightKg; }

    @Override public double calculateInsurance() { return 0.02 * declaredValue; }
}

class FragileParcel extends StandardParcel implements Insurable {
    private static final double HANDLING_FEE = 50;

    FragileParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }

    @Override String getType() { return "FRAGILE"; }

    @Override double calculateCharge() { return super.calculateCharge() + HANDLING_FEE; }

    @Override public double calculateInsurance() { return 0.02 * declaredValue; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel p;
            switch (type) {
                case "STANDARD": p = new StandardParcel(weight, value); break;
                case "EXPRESS":  p = new ExpressParcel(weight, value); break;
                case "FRAGILE":  p = new FragileParcel(weight, value); break;
                default: throw new IllegalArgumentException("Unknown parcel type: " + type);
            }
            double charge = p.calculateCharge();
            double insurance = (p instanceof Insurable) ? ((Insurable) p).calculateInsurance() : 0;
            double total = charge + insurance;
            grand += total;
            System.out.println(String.format(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f",
                    p.getType(), charge, insurance, total));
        }
        System.out.println(String.format(Locale.US, "Grand Total: %.2f", grand));
    }
}

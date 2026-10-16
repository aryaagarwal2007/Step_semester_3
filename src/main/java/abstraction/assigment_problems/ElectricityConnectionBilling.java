package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

abstract class Connection {
    protected final int units;

    Connection(int units) { this.units = units; }

    abstract String getType();

    abstract double calculateBill();
}

class HomeConnection extends Connection {
    private static final int SLAB_LIMIT = 100;

    HomeConnection(int units) { super(units); }

    @Override String getType() { return "HOME"; }

    @Override double calculateBill() {
        if (units <= SLAB_LIMIT) return units * 5.0;
        return SLAB_LIMIT * 5.0 + (units - SLAB_LIMIT) * 7.0;
    }
}

class ShopConnection extends Connection {
    private static final double FIXED_CHARGE = 100;

    ShopConnection(int units) { super(units); }

    @Override String getType() { return "SHOP"; }

    @Override double calculateBill() { return units * 8.0 + FIXED_CHARGE; }
}

class FactoryConnection extends Connection {
    private static final double MIN_BILL = 1000;

    FactoryConnection(int units) { super(units); }

    @Override String getType() { return "FACTORY"; }

    @Override double calculateBill() { return Math.max(units * 6.0, MIN_BILL); }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();
            Connection c;
            switch (type) {
                case "HOME":    c = new HomeConnection(units); break;
                case "SHOP":    c = new ShopConnection(units); break;
                case "FACTORY": c = new FactoryConnection(units); break;
                default: throw new IllegalArgumentException("Unknown connection type: " + type);
            }
            double bill = c.calculateBill();
            total += bill;
            System.out.println(String.format(Locale.US, "%s: %.2f", c.getType(), bill));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}

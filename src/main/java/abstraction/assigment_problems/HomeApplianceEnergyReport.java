package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

// Ability: only some appliances have a saver mode.
interface SaverMode {
    double SAVER_REDUCTION = 0.25;

    default double applySaver(double units) { return units * (1 - SAVER_REDUCTION); }
}

abstract class Appliance {
    private static final double RATE_PER_UNIT = 8;

    protected final double hours;

    Appliance(double hours) { this.hours = hours; }

    abstract String getName();

    abstract double getPowerWatts();

    double calculateUnits() { return getPowerWatts() * hours / 1000; }

    double calculateCost(double units) { return units * RATE_PER_UNIT; }
}

class Fridge extends Appliance {
    Fridge(double hours) { super(hours); }

    @Override String getName() { return "FRIDGE"; }

    @Override double getPowerWatts() { return 150; }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) { super(hours); }

    @Override String getName() { return "AC"; }

    @Override double getPowerWatts() { return 1500; }
}

class Tv extends Appliance {
    Tv(double hours) { super(hours); }

    @Override String getName() { return "TV"; }

    @Override double getPowerWatts() { return 100; }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) { super(hours); }

    @Override String getName() { return "WASHER"; }

    @Override double getPowerWatts() { return 500; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equalsIgnoreCase("SAVER");
            Appliance a;
            switch (type) {
                case "FRIDGE": a = new Fridge(hours); break;
                case "AC":     a = new AirConditioner(hours); break;
                case "TV":     a = new Tv(hours); break;
                case "WASHER": a = new WashingMachine(hours); break;
                default: throw new IllegalArgumentException("Unknown appliance: " + type);
            }
            double units = a.calculateUnits();
            if (saver) {
                if (a instanceof SaverMode) {
                    units = ((SaverMode) a).applySaver(units);
                } else {
                    System.out.println(a.getName() + ": saver mode not supported");
                    continue;
                }
            }
            double cost = a.calculateCost(units);
            total += cost;
            System.out.println(String.format(Locale.US, "%s: Units=%.2f Cost=%.2f", a.getName(), units, cost));
        }
        System.out.println(String.format(Locale.US, "Total Cost: %.2f", total));
    }
}

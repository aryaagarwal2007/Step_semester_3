package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

// Ability: only some cabs offer night service.
interface NightService {
    double NIGHT_SURCHARGE = 0.20;

    default double applyNightSurcharge(double fare) { return fare * (1 + NIGHT_SURCHARGE); }
}

abstract class Cab {
    // The minimum fare rule is shared by every cab.
    private static final double MINIMUM_FARE = 100;

    abstract String getName();

    abstract double getRatePerKm();

    double calculateFare(double km) { return Math.max(km * getRatePerKm(), MINIMUM_FARE); }
}

class MiniCab extends Cab {
    @Override String getName() { return "MINI"; }

    @Override double getRatePerKm() { return 10; }
}

class SedanCab extends Cab implements NightService {
    @Override String getName() { return "SEDAN"; }

    @Override double getRatePerKm() { return 14; }
}

class SuvCab extends Cab implements NightService {
    @Override String getName() { return "SUV"; }

    @Override double getRatePerKm() { return 18; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            boolean night = sc.next().equalsIgnoreCase("NIGHT");
            Cab cab;
            switch (type) {
                case "MINI":  cab = new MiniCab(); break;
                case "SEDAN": cab = new SedanCab(); break;
                case "SUV":   cab = new SuvCab(); break;
                default: throw new IllegalArgumentException("Unknown cab type: " + type);
            }
            double fare = cab.calculateFare(km);
            if (night) {
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).applyNightSurcharge(fare);
                } else {
                    System.out.println(cab.getName() + ": night service not available");
                    continue;
                }
            }
            total += fare;
            System.out.println(String.format(Locale.US, "%s: %.2f", cab.getName(), fare));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}

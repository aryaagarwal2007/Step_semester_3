package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

// Ability: only some students use the college bus.
interface BusUser {
    // The transport fee is written in exactly one place.
    double TRANSPORT_FEE = 12000;

    default double getTransportFee() { return TRANSPORT_FEE; }
}

abstract class Student {
    private final String name;

    Student(String name) { this.name = name; }

    String getName() { return name; }

    abstract double calculateTuition();

    double calculateTotalFee() {
        double fee = calculateTuition();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) { super(name); }

    @Override double calculateTuition() { return 40000; }
}

class Hosteller extends Student {
    private static final double HOSTEL_FEE = 60000;

    Hosteller(String name) { super(name); }

    @Override double calculateTuition() { return 40000 + HOSTEL_FEE; }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) { super(name); }

    @Override double calculateTuition() { return 40000 / 2.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            Student s;
            switch (type) {
                case "DAY_SCHOLAR": s = new DayScholar(name); break;
                case "HOSTELLER":   s = new Hosteller(name); break;
                case "SCHOLAR":     s = new ScholarshipStudent(name); break;
                default: throw new IllegalArgumentException("Unknown student type: " + type);
            }
            double fee = s.calculateTotalFee();
            total += fee;
            System.out.println(String.format(Locale.US, "%s: %.2f", s.getName(), fee));
        }
        System.out.println(String.format(Locale.US, "Total Collected: %.2f", total));
    }
}

package abstraction.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

abstract class Staff {
    private final String name;

    Staff(String name) { this.name = name; }

    String getName() { return name; }

    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private final double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) { super(name); this.weeklySalary = weeklySalary; }

    @Override double calculatePay() { return weeklySalary; }
}

class HourlyStaff extends Staff {
    private static final double REGULAR_HOURS = 40;
    private static final double OVERTIME_MULTIPLIER = 1.5;
    private final double hours, rate;

    HourlyStaff(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }

    @Override double calculatePay() {
        if (hours <= REGULAR_HOURS) return hours * rate;
        return REGULAR_HOURS * rate + (hours - REGULAR_HOURS) * rate * OVERTIME_MULTIPLIER;
    }
}

class InternStaff extends Staff {
    private final double stipend;

    InternStaff(String name, double stipend) { super(name); this.stipend = stipend; }

    @Override double calculatePay() { return stipend; }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            Staff s;
            switch (type) {
                case "FULLTIME": s = new FullTimeStaff(name, sc.nextDouble()); break;
                case "HOURLY":   s = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble()); break;
                case "INTERN":   s = new InternStaff(name, sc.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown staff type: " + type);
            }
            double pay = s.calculatePay();
            total += pay;
            System.out.println(String.format(Locale.US, "%s: %.2f", s.getName(), pay));
        }
        System.out.println(String.format(Locale.US, "Total Payroll: %.2f", total));
    }
}

package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Assignment 5: The Streaming Plan Renewal Reminder
 *
 * Plan is an abstract base type exposing getValidityDays(); each subclass
 * fixes its own validity period. getRenewalDate() lives once, in the base
 * class, reusing whatever validity period the subclass provides.
 */
public class StreamingPlanRenewalReminder {

    static abstract class Plan {
        protected final String name;
        protected final LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int getValidityDays();

        LocalDate getRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }

    static class BasicPlan extends Plan {
        BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int getValidityDays() {
            return 30;
        }
    }

    static class StandardPlan extends Plan {
        StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int getValidityDays() {
            return 90;
        }
    }

    static class PremiumPlan extends Plan {
        PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        int getValidityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Plan> plans = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            switch (type) {
                case "BASIC":
                    plans.add(new BasicPlan(name, startDate));
                    break;
                case "STANDARD":
                    plans.add(new StandardPlan(name, startDate));
                    break;
                case "PREMIUM":
                    plans.add(new PremiumPlan(name, startDate));
                    break;
                default:
                    System.out.println("Unknown plan type: " + type);
            }
        }

        for (Plan p : plans) {
            System.out.println(p.name + ": " + p.getRenewalDate().format(fmt));
        }
    }
}

package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Assignment 4: The Festival Bonus Calculator
 *
 * EmployeeBonus is an abstract base type; each subclass overrides
 * calculateBonus() with its own rule (Intern's fixed bonus ignores salary
 * entirely). The payroll loop calls calculateBonus() uniformly.
 */
public class FestivalBonusCalculator {

    static abstract class EmployeeBonus {
        protected final String name;
        protected final double monthlySalary;

        EmployeeBonus(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double calculateBonus();
    }

    static class FullTimeEmployee extends EmployeeBonus {
        FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        double calculateBonus() {
            return monthlySalary * 0.10;
        }
    }

    static class PartTimeEmployee extends EmployeeBonus {
        PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        double calculateBonus() {
            return monthlySalary * 0.05;
        }
    }

    static class Intern extends EmployeeBonus {
        Intern(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        double calculateBonus() {
            return 2000.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<EmployeeBonus> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            switch (type) {
                case "FULLTIME":
                    employees.add(new FullTimeEmployee(name, salary));
                    break;
                case "PARTTIME":
                    employees.add(new PartTimeEmployee(name, salary));
                    break;
                case "INTERN":
                    employees.add(new Intern(name, salary));
                    break;
                default:
                    System.out.println("Unknown employee type: " + type);
            }
        }

        double total = 0;
        for (EmployeeBonus e : employees) {
            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f%n", e.name, bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}

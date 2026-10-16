package data_structure.class_problems;

import java.util.Scanner;

public class LeapYearDetector {

    static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(isLeap(sc.nextInt()) ? "Leap year" : "Not a leap year");
        }
    }
}

package data_structure.class_problems;

import java.util.Scanner;

public class DigitSumAndReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        long sum = 0, reversed = 0;
        while (number > 0) {
            long digit = number % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }
}

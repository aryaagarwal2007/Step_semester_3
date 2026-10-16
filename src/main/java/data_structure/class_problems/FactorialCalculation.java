package data_structure.class_problems;

import java.util.Scanner;

public class FactorialCalculation {

    // long is enough up to 20!
    static long factorial(int n) {
        long result = 1;          // also covers 0! = 1
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(factorial(sc.nextInt()));
        }
    }
}

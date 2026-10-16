package data_structure.assigment_problems;

import java.util.Scanner;

/**
 * Problem 7: Second-Best Score
 *
 * Input : n, then n scores.
 * Output: second-highest distinct score, or -1 if it does not exist.
 *
 * Complexity: O(n) time, O(1) space (single pass, two variables).
 * Sorting first would cost O(n log n) time (and extra space depending on the
 * sort), and the problem forbids it anyway.
 */
public class SecondBestScore {

    static int secondHighest(int[] scores) {
        int highest = -1, second = -1;       // scores are >= 0, so -1 means "none yet"
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s != highest && s > second) {
                second = s;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        System.out.println(secondHighest(scores));
    }
}

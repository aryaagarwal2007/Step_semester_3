package data_structure.assigment_problems;

import java.util.Scanner;

/**
 * Problem 6: Class Attendance Tracker
 *
 * Input : n, then n values (1 = present, 0 = absent).
 * Output: Present: p, Longest streak: s
 *
 * Complexity: O(n) time, O(1) space. Both answers are found in a single pass.
 */
public class ClassAttendanceTracker {

    // Returns {presentDays, longestStreak}.
    static int[] attendanceSummary(int[] days) {
        int present = 0, longest = 0, current = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                current++;
                if (current > longest) longest = current;
            } else {
                current = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) days[i] = sc.nextInt();
        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
    }
}

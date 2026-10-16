package data_structure.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem 8: Duty Roster Rotation
 *
 * Input : n, then n names, then k.
 * Output: roster rotated right by k places, e.g. [D, E, A, B, C].
 *
 * Complexity: O(n) time, O(n) extra space for the result array.
 * Rotating one place at a time, k times, costs O(n * k). With k up to 10^9
 * that is far too slow, and it is pointless because k % n gives the same result.
 */
public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);           // remove full turns
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[(i + shift) % n] = names[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = sc.next();
        long k = sc.nextLong();
        System.out.println(Arrays.toString(rotateRoster(names, k)));
    }
}

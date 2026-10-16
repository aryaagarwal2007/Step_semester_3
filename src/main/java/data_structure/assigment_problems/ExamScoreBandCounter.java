package data_structure.assigment_problems;

import java.util.Scanner;

/**
 * Problem 4: Exam Score Band Counter
 *
 * Input : n, then n sorted scores, then low and high.
 * Output: number of scores s with low <= s <= high.
 *
 * Complexity
 *  - Linear scan : O(n) time, O(1) space.
 *  - Binary search (this solution): O(log n) time, O(1) space.
 *
 * Duplicates: a normal binary search stops at ANY matching element, which could be
 * in the middle of a run of equal scores. To count the whole band we need exact
 * edges, so we keep searching after a match:
 *   firstAtLeast(low)  -> first index with score >= low  (move left on a match)
 *   firstGreater(high) -> first index with score >  high (move right on a match)
 * The answer is the difference of the two positions.
 */
public class ExamScoreBandCounter {

    // First index whose score is >= target (n if none).
    static int firstAtLeast(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    // First index whose score is > target (n if none).
    static int firstGreater(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return firstGreater(scores, high) - firstAtLeast(scores, low);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(countInBand(scores, low, high));
    }
}

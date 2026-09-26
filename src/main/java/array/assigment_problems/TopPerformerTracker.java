package array.assigment_problems;

/**
 * PROBLEM 3: Top Performer Tracker
 *
 * Single pass tracking both a running min and a running max at once —
 * no sorting needed to report the spread between them.
 */
public class TopPerformerTracker {

    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) min = scores[i];
            if (scores[i] > max) max = scores[i];
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        System.out.println(findMinMaxSpread(new int[]{45, 82, 79, 90, 33, 90, 61}));
        // Expected: Min: 33 | Max: 90 | Spread: 57
    }
}

package array.assigment_problems;

/**
 * PROBLEM 4: Match Day Grid Analyzer
 *
 * rowAverage() does exactly one job: compute one match's average and return it.
 * classifyMatches() is the only place that decides Power Surge vs. Normal.
 * Rows (matches) may have different lengths (a different number of overs).
 */
public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);
            String status = (average >= threshold) ? "Power Surge" : "Normal";

            result.append("Match ").append(i).append(": ").append(status);
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));
        // Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}

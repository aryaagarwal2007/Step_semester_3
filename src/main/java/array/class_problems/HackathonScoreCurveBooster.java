package array.class_problems;

import java.util.Arrays;

/**
 * PROBLEM 1 (Practice): Hackathon Score Curve Booster
 *
 * Boosts every score in the array in place — no new array, no return value.
 */
public class HackathonScoreCurveBooster {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores));
        // Expected: [80, 95, 70]
    }
}

package array.assigment_problems;

import java.util.Arrays;

/**
 * PROBLEM 1: Fantasy Team Score Multiplier
 *
 * Modifies the caller's array directly. Only two specific positions change —
 * no loop over the whole array is needed, just two direct index assignments.
 */
public class FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
        // Expected: [40.0, 110.0, 30.0, 93.0]
    }
}

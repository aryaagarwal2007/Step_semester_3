package array.class_problems;

import java.util.Arrays;

/**
 * L1. Two Sum
 *
 * Nested loops check every pair of different positions (i, j).
 * Returns the indices as soon as a matching pair is found.
 */
public class TwoSum {

    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // no valid pair (won't happen per problem's guarantee)
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        // Expected: [0, 1]

        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        // Expected: [1, 2]
    }
}

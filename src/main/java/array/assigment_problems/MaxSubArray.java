package array.assigment_problems;

/**
 * A2. Maximum Subarray (Kadane's Algorithm)
 *
 * At each element, decide whether to extend the current running subarray
 * or abandon it and start fresh from the current element.
 * Time: O(n)   Extra space: O(1)
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start a new one at nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        // Expected: 6  (subarray [4, -1, 2, 1])

        System.out.println(maxSubArray(new int[]{-3, -1, -2}));
        // Expected: -1
    }
}

package array.assigment_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * A4. Subarray Sum Equals K
 *
 * sum(i+1..j) = prefixSum[j] - prefixSum[i]. So at each position, the number
 * of earlier prefix sums equal to (currentSum - k) tells us how many valid
 * subarrays end here. A sliding window doesn't work because nums can be negative.
 * Time: O(n)   Space: O(n)
 */
public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // empty prefix, needed for subarrays starting at index 0

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            count += prefixCount.getOrDefault(currentSum - k, 0);
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        // Expected: 2

        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
        // Expected: 3
    }
}

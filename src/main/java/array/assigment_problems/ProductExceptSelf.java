package array.assigment_problems;

import java.util.Arrays;

/**
 * A1. Product of Array Except Self
 *
 * For every index i, answer[i] = product of all elements in nums except nums[i].
 * No division used. Two passes: prefix products, then suffix products multiplied in.
 * Time: O(n)   Extra space: O(1) beyond the output array.
 */
public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: answer[i] holds product of everything to the LEFT of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: multiply in the running product of everything to the RIGHT of i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        // Expected: [24, 12, 8, 6]

        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        // Expected: [0, 0, 9, 0, 0]
    }
}

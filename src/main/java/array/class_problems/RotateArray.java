package array.class_problems;

import java.util.Arrays;

/**
 * L5. Rotate Array
 *
 * Reduce k with modulo first (rotating by a full array length changes nothing),
 * then place each element directly at its new position in a fresh array.
 */
public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        // Expected: [5, 6, 7, 1, 2, 3, 4]

        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2}, 3)));
        // Expected: [2, 1]
    }
}

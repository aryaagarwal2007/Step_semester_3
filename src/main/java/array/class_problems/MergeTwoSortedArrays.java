package array.class_problems;

import java.util.Arrays;

/**
 * L4. Merge Two Sorted Arrays
 *
 * Two-pointer technique: one index into each array, a while loop copying
 * the smaller current element into the result, then copying over whatever
 * remains once one array runs out first.
 */
public class MergeTwoSortedArrays {

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy over whichever array still has elements left
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6})));
        // Expected: [1, 2, 3, 4, 5, 6]

        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{}, new int[]{1, 2, 3})));
        // Expected: [1, 2, 3]
    }
}

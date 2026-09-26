package array.assigment_problems;

/**
 * A5. Find Minimum in Rotated Sorted Array
 *
 * Modified binary search: compare the middle element to the rightmost element
 * to decide which half must contain the minimum.
 * Time: O(log n)
 */
public class FindMinInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be to the right of mid (rotation point is there)
                left = mid + 1;
            } else {
                // nums[mid] <= nums[right]: minimum is at mid or to its left
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        // Expected: 1

        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        // Expected: 0

        System.out.println(findMin(new int[]{11, 13, 15, 17}));
        // Expected: 11
    }
}

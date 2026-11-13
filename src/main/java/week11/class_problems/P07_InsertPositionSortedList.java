package week11.class_problems;

// Binary search: Time O(log n), Space O(1)
public class P07_InsertPositionSortedList {
    static int searchInsertPosition(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1; else hi = mid - 1;
        }
        return lo; // insertion point
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsertPosition(nums, 5));
        System.out.println(searchInsertPosition(nums, 2));
    }
}

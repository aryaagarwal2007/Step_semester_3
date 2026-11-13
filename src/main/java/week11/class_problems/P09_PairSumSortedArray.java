package week11.class_problems;

// Two pointers: Time O(n), Space O(1)
// Ignoring the sorted property (all pairs): Time O(n^2).
public class P09_PairSumSortedArray {
    // returns {a, b} or null if no pair exists
    static int[] pairSumSorted(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int s = nums[l] + nums[r];
            if (s == target) return new int[]{nums[l], nums[r]};
            if (s < target) l++; else r--;
        }
        return null;
    }

    static void show(int[] nums, int target) {
        int[] p = pairSumSorted(nums, target);
        System.out.println(p == null ? "Not Found" : "(" + p[0] + ", " + p[1] + ")");
    }

    public static void main(String[] args) {
        show(new int[]{-4, -1, 0, 3, 5, 9}, 4);
        show(new int[]{1, 2, 3}, 100);
    }
}

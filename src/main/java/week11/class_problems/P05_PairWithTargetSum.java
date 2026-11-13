package week11.class_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Approach 1 (brute force): Time O(n^2), Space O(1)
// Approach 2 (hash set):    Time O(n),   Space O(n)
// Approach 3 (sort + two pointers): Time O(n log n), Space O(1) extra
public class P05_PairWithTargetSum {
    static boolean bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) return true;
        return false;
    }

    static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(target - x)) return true;
            seen.add(x);
        }
        return false;
    }

    static boolean sortTwoPointers(int[] nums, int target) {
        int[] a = nums.clone();
        Arrays.sort(a); // fine here: the "no Arrays.sort" rule applies to the sorting assignment
        int l = 0, r = a.length - 1;
        while (l < r) {
            int s = a[l] + a[r];
            if (s == target) return true;
            if (s < target) l++; else r--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));
    }
}

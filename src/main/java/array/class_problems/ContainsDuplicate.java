package array.class_problems;

/**
 * L3. Contains Duplicate
 *
 * Nested loops compare every element at position i against every element
 * at a different position j, returning true the moment a match is found.
 */
public class ContainsDuplicate {

    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        // Expected: true

        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        // Expected: false
    }
}

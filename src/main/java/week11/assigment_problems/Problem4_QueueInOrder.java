package week11.assigment_problems;

// Single pass: Time O(n), Space O(1)
public class Problem4_QueueInOrder {
    static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstBreak(new int[]{3, 5, 5, 8, 6, 9}));
        System.out.println(firstBreak(new int[]{1, 2, 2, 7}));
        System.out.println(firstBreak(new int[]{}));        // my own tests
        System.out.println(firstBreak(new int[]{9, 4}));
    }
}

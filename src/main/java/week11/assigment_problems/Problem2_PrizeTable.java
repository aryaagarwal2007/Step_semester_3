package week11.assigment_problems;

import java.util.Arrays;

// Selection sort (descending), counting only real swaps.
public class Problem2_PrizeTable {
    static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIdx]) maxIdx = j;
            }
            if (maxIdx != i) {
                int t = marks[i]; marks[i] = marks[maxIdx]; marks[maxIdx] = t;
                swaps++;
            }
        }
        return swaps;
    }

    static void run(int[] marks) {
        int swaps = prizeTable(marks);
        System.out.println(Arrays.toString(marks) + " swaps = " + swaps);
    }

    public static void main(String[] args) {
        run(new int[]{45, 90, 60, 75});
        run(new int[]{80, 70, 60});
        run(new int[]{10, 20, 30, 40, 50}); // my own test
    }
}

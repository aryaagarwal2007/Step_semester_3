package data_structure.assigment_problems;

import java.util.Scanner;

/**
 * Problem 10: Busiest Bus Row
 *
 * Input : r and c, then the r x c grid.
 * Output: Row i, Total t  (smaller index wins a tie).
 *
 * Complexity: O(r * c) time, O(1) additional space.
 */
public class BusiestBusRow {

    // Returns {rowIndex, total}.
    static int[] busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = -1;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }
            if (total > bestTotal) {      // strictly larger, so ties keep the smaller index
                bestTotal = total;
                bestRow = i;
            }
        }
        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                grid[i][j] = sc.nextInt();
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}

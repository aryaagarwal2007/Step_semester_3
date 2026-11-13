package week11.class_problems;

import java.util.Arrays;

// Time: O(m * n) | Extra space: O(1)
public class P02_WarehouseBinGridScan {
    // returns {total, row, col}
    static int[] warehouseSummary(int[][] grid) {
        int total = 0, max = Integer.MIN_VALUE, r = -1, c = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > max) { // strict > keeps the first max found
                    max = grid[i][j];
                    r = i; c = j;
                }
            }
        }
        return new int[]{total, r, c};
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 9, 2}, {7, 1, 6}, {3, 12, 5}};
        int[] res = warehouseSummary(grid);
        System.out.println("total = " + res[0] + ", maxCoordinate = (" + res[1] + ", " + res[2] + ")");
    }
}

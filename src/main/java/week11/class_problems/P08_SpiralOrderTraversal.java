package week11.class_problems;

import java.util.ArrayList;
import java.util.List;

// Time: O(m * n) | Output space: O(m * n)
public class P08_SpiralOrderTraversal {
    static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> out = new ArrayList<>();
        if (grid.length == 0) return out;
        int top = 0, bottom = grid.length - 1, left = 0, right = grid[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) out.add(grid[top][j]);
            top++;
            for (int i = top; i <= bottom; i++) out.add(grid[i][right]);
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) out.add(grid[bottom][j]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) out.add(grid[i][left]);
                left++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(grid));
    }
}

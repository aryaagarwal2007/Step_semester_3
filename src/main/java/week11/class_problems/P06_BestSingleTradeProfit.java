package week11.class_problems;

// Single pass: Time O(n), Space O(1)  |  Every pair: Time O(n^2), Space O(1)
// For millions of days the single pass is far faster.
public class P06_BestSingleTradeProfit {
    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, best = 0;
        for (int p : prices) {
            if (p < minPrice) minPrice = p;
            else best = Math.max(best, p - minPrice);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}

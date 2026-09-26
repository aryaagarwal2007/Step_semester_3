package array.class_problems;

/**
 * L2. Best Time to Buy and Sell Stock
 *
 * Single pass: track the lowest price seen so far, and at each day compute
 * the profit from selling today versus that running minimum.
 */
public class BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices) {
        int minPriceSoFar = prices[0];
        int maxProfitSoFar = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - minPriceSoFar;
            maxProfitSoFar = Math.max(maxProfitSoFar, profitIfSoldToday);
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
        }

        return maxProfitSoFar;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        // Expected: 5

        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        // Expected: 0
    }
}

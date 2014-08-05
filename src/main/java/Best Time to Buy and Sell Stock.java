public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                min = prices[i];
            } else {
                min = prices[i] < min ? prices[i] : min;
            }
            int profit = prices[i] - min;
            max = profit > max ? profit : max;
        }
        return max;
    }
}
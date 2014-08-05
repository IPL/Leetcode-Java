public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0)
            return 0;
        // only record the header and footer of acsending sequence.
        int[] fromStart = new int[length];
        int[] fromEnd = new int[length];
        fromStart[0] = 0;
        int min = prices[0];
        for (int i = 1; i< length; i++) {
            fromStart[i] = Math.max(fromStart[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        int max = prices[length -1];
        fromEnd[length -1] = 0;
        for (int i = length -2; i>=0; i--) {
            fromEnd[i] = Math.max(fromEnd[i+1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        int sum = 0;
        for (int i = 0; i < length; i++)
            sum = Math.max(sum, fromStart[i] + fromEnd[i]);

        return sum;
    }
}
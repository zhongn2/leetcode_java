public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int[] maxLeft = new int[prices.length];
        int[] maxRight = new int[prices.length];
        int profit = 0;
        
        int m = prices[0];
        maxLeft[0] = 0;
        // every ith stock is calculated by the i-1 stock
        // from left to the right and it is for the buy price
        for(int i = 1; i < prices.length; i++){
            m = Math.min(m, prices[i]);
            maxLeft[i] = Math.max(maxLeft[i-1], prices[i] - m);
        }
        // from right to the left
        // for the sell price
        int n = prices[prices.length - 1];
        maxRight[prices.length - 1] = 0;
        for(int i = prices.length - 2; i >= 0; i--){
            n = Math.max(n, prices[i]);
            maxRight[i] = Math.max(maxRight[i+1], n - prices[i]);
        }
        // for the whole array
        for(int i = 0; i < prices.length; i++){
            profit = Math.max(profit, maxLeft[i] + maxRight[i]);
            
        }
        
        return profit;
 
    }
}
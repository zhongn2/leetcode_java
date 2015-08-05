/*
	最多允许两次买卖，无论如何，两次买卖处于不同的区间里，我们相当于分割了整个数组
	左边scan一次，得到每个分割位置的最大利润值[0....i]
	再右边scan一次，得到右边每个位置的最大利润值[i+1..... end]
	最后取一个最大值

*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 0;
        int min  = prices[0];
        
        for(int i = 1; i < len; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i-1], prices[i] - min);
        }
        
        right[len-1] = 0;
        int max = prices[len-1];
        
        for(int i = len -2; i > 0; i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i+1], max - prices[i]);
        }
        
        int profit = 0;
        
        for(int i = 0; i < len; i++){
            profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit;
    }
}
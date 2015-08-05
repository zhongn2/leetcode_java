/*
	第一题就相当于找一个最小的买入，最大的卖出
	找最小的话： min = Math.min(min, prices[i]);
	计算利润： profit = Math.max(profit, prices[i] - min);

*/



public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        
        int profit = 0;
        int min = prices[0];
        
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}

/*
	第二个stock是说无论几次，只要赚钱我就买卖。
	所以不考虑次数，我们比较 2 5 8， sum = (5-2) + (8-5) = (8-2)
	最后再将local的值相加得到最后的结果


*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 0) return 0;
        
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++){
            int localProfit = prices[i] - prices[i-1];
            if(localProfit > 0) {
                profit += localProfit;
        }
    }
    
    return profit;
    }
}
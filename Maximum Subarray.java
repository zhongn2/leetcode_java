public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            sum = Math.max(sum, 0);
        }
       
       return maxSum;
  
    }
}
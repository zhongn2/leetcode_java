/*
滑动窗口的思想
两个指针，right负责移动，先计算local sum, 如果小于S，right指针移动
直到local sum >= s 为止。这时候，update minLen, 同时将left的元素移除
这个思想可以用来求最短subarray >= target
和two sum 的对比在于：two sum 允许排序，找两个index,所以可以设定两个指针移动

*/



public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int localSum = 0;
        int minLen = Integer.MAX_VALUE;
        
        while(right < nums.length){
            localSum += nums[right];
            
            while(localSum >= s){
                minLen = Math.min(minLen, right - left + 1);
                localSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
      
    }
}
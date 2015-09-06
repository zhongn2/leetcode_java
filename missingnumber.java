/*
	1. 排序：0(nlogn)，如果需要constant space
	2. O(n)， 参考 find missing postive 
	3. 很容易想到 用sum of [0...n] - sum of nums
	问题是：如何避免overflow的问题，所以这里我们加上的是当前index 和数值的差


*/


public class Solution {
    public int missingNumber(int[] nums) {
       if(nums == null) return -1;
       int res = nums.length;
       
       for(int i = 0; i < nums.length; i++){
           res += i - nums[i];
       }
       return res;
    }
}
}
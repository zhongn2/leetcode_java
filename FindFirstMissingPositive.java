/*
	很有趣的一道题
	利用index本身的特点，让每个数都按照index的顺序排列，主要的操作是swap，但是被swap的两个数必须不同，否则容易死循环
	再遍历一遍，找到不在正确位置的数，并返回index
	如果都在正确的位置，则返回数组的最后一个位置 +１
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null) return -1;
        
        for(int i = 0; i < nums.length; i++){
            // positive, in the range and the swap elments can't be equal
            while(nums[i] > 0 && nums[i]<= nums.length && nums[i] != nums[nums[i] -1]){
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        // search again to see which elment is not in the right index
         for(int i = 0; i < nums.length; i++){
             if(nums[i] != i + 1){
                 return i + 1;
             }
         }
         // otherwise return the end + 1
         return nums.length + 1;
        
    }
}
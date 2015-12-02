/*
关键点在于分奇偶，array 的index奇数的时候我们要保证num[i] > nums[i-1]
偶数的时候，num[i] < nums[i-1]

*/



public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
       
        for(int i = 1; i < nums.length; i++){
            if((i % 2 == 1) != nums[i] > nums[i-1]){
                int tmp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = tmp;
            }
            
        }
    }
}
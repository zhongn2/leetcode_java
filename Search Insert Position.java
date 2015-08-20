/*
	思想是用二分查找找数，有的话返回index，找不到分为几种情况：
	1. 在start那边，<= start, return start
	2. 在end 那边， <= end， return end
	3. 比end 大，则return end + 1
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        
        if(nums[0] > target){
            return 0;
        }
        
        while(start + 1< end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(target <= nums[start]){
            return start;
        }else if(target <= nums[end]){
            return end;
        }else{
            return end + 1;
        }
    }
}
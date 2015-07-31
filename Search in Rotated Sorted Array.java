public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null) return -1;
        int start = 0;
        int end = nums.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            
            if(nums[mid] == target){
                 return mid;
            }
            // from start to the mid, it's an ascending order
            // we need to make sure that 
            if(nums[start] < nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        
        return -1;
        
    }
}
}

/*
	FOLLOW UP: when duplicate numbers are allowed
	Run time is O(n), 当中间值和边缘值相等的时候，我们无法决定哪一边被丢掉，所以只有一个一个的遍历看是否和target相当，也就是遍历一遍
*/
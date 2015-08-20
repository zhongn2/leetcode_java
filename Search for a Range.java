/*
左边一个bound, 右边一个bound,通过两次binary search来找到index


*/


public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) return res;
        
        int start = 0;
        int end = nums.length - 1;
        //left bound是用start来记录的
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        if(nums[start] == target){
            res[0] = start;
        }else{
            return res;
        }
        // right bound 用end来记录
        start = 0;
        end = nums.length - 1;
         while(start  < end){
             int mid = start + (end -start + 1) / 2;
             if(nums[mid] <= target){
                 start = mid;
             }else{
                 end = mid-1;
             }
         }
         if(nums[end] == target){
             res[1] = end;
         }
       
        
        return res;
    }
}
// delete the numbers
// keep the former elemnts and move the afterwards elment by (index2 - index2) steps
        
            
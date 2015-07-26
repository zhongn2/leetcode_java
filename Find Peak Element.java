
// log(n) usually is Binary search
// if the mid elemnt > next elment, the local max would be in the left side
// else it should at the right side 
// typical binary search solution

public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0) return 0;
        int start = 0;
        int end = nums.length- 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
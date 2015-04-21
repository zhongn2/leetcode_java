public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        // what if k > num.length, so we need to use m instead of k
        int m = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, m -1);
        reverse(nums, m, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
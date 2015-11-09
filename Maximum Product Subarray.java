public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int max_tmp = nums[0];
        int min_tmp = nums[0];
        int max_product = nums[0];
        // 考虑到负负得正的情况，我们需要record min值和max值
		//
        for(int i = 1; i < nums.length; i++){
            int curr_max = max_tmp * nums[i];
            int curr_min = min_tmp * nums[i];
            
            max_tmp = Math.max(Math.max(curr_max, curr_min),nums[i]);
            min_tmp = Math.min(Math.min(curr_max, curr_min),nums[i]);
           
            max_product = Math.max(max_tmp, max_product);
            
        }
        return max_product;
    }
}
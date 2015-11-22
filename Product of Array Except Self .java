/*
for example: A = [a1,a2, a3, a4]
the result is [a2*a3*a4, a1*a3*a4, a1*a2*a4, a1*a2*a3]
could be multipled by [1, a1, a1*a2, a1*a2*a3] 
				and   [a2*a3*a4, a3*a4,a4, 1]
O(1) space complexcity:
 we use temp to store the result of first array and update later


*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        if(nums == null || len == 0) return result;
        
        int temp = 1;
        result[0] = temp;
        //temp 的作用是节约空间
        for(int i = 1; i < len; i++){
            temp *= nums[i-1];
            result[i] = temp;
			// solution 2: result[i] = result[i-1] * nums[i-1];
        }
        
        temp = 1;
        
        for(int j = len - 2; j >= 0; j--){
            temp *= nums[j+1];
            result[j] *= temp;
        }
        
        return result;
    }
}

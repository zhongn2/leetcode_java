/**
做法：
	1. 从right to left, 找到第一个不递增的数i
	2. 从right to left， 找到第一个比i大的数j
	3. swap(i, j)
	4. reverse from i to the end
	For example: 2 3 4 5 6 1 -> 2 3 6 4 5 1 -> 2 3 1 5 4 6
**/

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i = 0;
        int j = 0;
        int len = nums.length;
        
        for(i = len - 2; i >= 0; i--){
            if(nums[i] >= nums[i+1]) continue;
            for(j = len -1; j > i; j--){
                if(nums[i] < nums[j]){
                    break;
                }
            }
            break;
        }
        // if i exists
        if(i >= 0){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
		//if i does not exist, reverse the whole array, 
		//which means we reach the end and turn back
        // reverse from i to the end
        int start = i + 1;
        int end = len - 1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
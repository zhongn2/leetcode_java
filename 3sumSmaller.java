/*
这道题的难点在于你用2 pointers，不是从头开始了，而是计划着i, j, k 三者的位置关系
在sorted好的数组，j - i 就是成立的triplet的个数

*/

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
         int count = 0;
		 Arrays.sort(nums);
		for (int k = 2; k < nums.length; k++) {
			int i = 0, j = k -1;
			while (i < j) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < target) {
					count += j - i;
					i++;
				}else {
					j--;
				}
			}
		}
	        
		return count;
    }
}
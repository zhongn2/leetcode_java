/*
	计数排序：two-passes algorithm. needs extra array
	Runtime is O(n)
	设置一个count数组，去计算每个数在原数组中出现的次数
	然后将每个数前面有多少个数计算出来，根据该信息可以知道元素的所在位置

*/

public static int[] countSort(int[] nums, int k){
		int[] counts = new int[k+1];
		int len = nums.length;
		int sum = 0;
		int[] copy = new int[len];
		
		// count how many elements 
		for (int i = 0; i < len; i++) {
			counts[nums[i]]++;
		}
		
		// get the sum of each elements
		for (int i = 0; i < counts.length; i++) {
			sum += counts[i];
			counts[i] = sum;
		}
		
		// iterate nums array from back
		for(int i = len - 1; i >= 0; i--){
			copy[counts[nums[i]] -1] = nums[i];
			counts[nums[i]]--;
			
		}
		
		return copy;
		
	}
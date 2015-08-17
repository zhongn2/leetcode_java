/*
找第几大的数，就变成找数组中第nums.length - k + 1个数
quick select 的思想是pivot左边的都小于pivot，右边的都大于pivot
我们每次从左边找比pivot大的数，从右边找比pivot小的数进行交换，最后将左边的值和pivot换
其实就是知道了pivot的顺序大小

*/
public int findKthLargest(int[] nums, int k) {
	if (k < 1 || nums == null) {
		return 0;
	}
	return getKth(nums.length - k +1, nums, 0, nums.length - 1);
}
 
public int getKth(int k, int[] nums, int start, int end) {
	int pivot = nums[end]; // whatever which position you pick, it does not matter.
	int left = start;
	int right = end;
 
	while (left < right) {
 
		while (nums[left] < pivot && left < right) {
			left++;
		}
 
		while (nums[right] >= pivot && right > left) {
			right--;
		}
		swap(nums, left, right);
	}
 
	swap(nums, left, end);
 
	if (k == left + 1) {
		return pivot;
	} else if (k < left + 1) {
		return getKth(k, nums, start, left - 1);
	} else {
		return getKth(k, nums, left + 1, end);
	}
}
 
public void swap(int[] nums, int n1, int n2) {
	int tmp = nums[n1];
	nums[n1] = nums[n2];
	nums[n2] = tmp;
}
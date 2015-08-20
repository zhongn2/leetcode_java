/*
	the new array should always be unique
	so we could start from thinking of A[0] A[1] A[2]...
	everytime we compare the element with former element to see if it is equal
	not equal, size ++, otherwise skip it and compare next element
	so the index of new array won't be changed until we find a different element
	const time and const space
	if we use hashset, the space complexcity is O(n)

*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[index]){
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}

//Remove Duplicates from Sorted Array II 
/*
follow up 是允许数列中每个数字出现次数为N,其实大同小异
index = n；

*/

public class Solution {
    public int removeDuplicates(int[] nums， int n) {
        if(nums.length == 0 || nums == null) return 0;
        int index = n;
        for(int i = n; i < nums.length; i++){
            if(nums[i] != nums[i - n]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
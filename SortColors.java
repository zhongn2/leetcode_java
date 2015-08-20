/*
    这道题也是partition的思想，先分为0和其他数字（1,2），然后再分为1和2再进行partition
    如果是in place，就把0放在最前面，1在中间，2在最后面，所以1没必要动
	再把0或者1放在前面的时候，i需要移动到下一位。而判断2的时候，放在末尾，进行交换，我们必须继续判断交换后的值
	所以i不需要往后移位。
*/

public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int start = 0;
        int end = nums.length -1;
        int i = 0;
        
        while(i <= end){
            if(nums[i] == 0){
                swap(start, i, nums);
                start++;
                i++;
            }else if(nums[i] == 2){
                swap(end, i, nums);
                end--; 
            }else{
                i++;
            }
        }
    }
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
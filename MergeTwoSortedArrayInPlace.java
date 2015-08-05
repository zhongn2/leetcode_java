
/*
	从后面merge，知道了数组的总长，只需要改变index即可。
	--index 是先-1 先变化

*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n;
        
        while(m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]) 
                nums1[--index] = nums1[--m];
            else    
                nums1[--index] = nums2[--n];
        }
        
        while(n > 0){
            nums1[--index] = nums2[--n];
        }
    }
}

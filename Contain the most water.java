public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int n = height.length;
        int maxArea = 0;
        int left = 0, right = n - 1;
        
        while(left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
        
    }
}
/*
这道题用的是two pointers, 左边和右边一起访问，水的容量取决于最短的bar 和两个板子之间的距离，
求最大的值的rule
int max = 0
max = Math.max(max, 其他的条件）
移动的指针的规律哪边短就++
*?
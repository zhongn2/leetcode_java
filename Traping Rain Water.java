/*每一点能接住的水量取决于它左边的最高高度，和右边的最高高度中相对低的那个。

water[i] = min(leftHighest[i], rightHighest[i]) - A[i];

如果左右两边的最高高度都比它低，water[i] < 0，说明没法接住水。

leftHighest[]和rightHighest[]可以通过两遍扫描，用O(n)的时间求出来。
每一个点能够接水，取决于高度，看左右两边最高短板的差
*/

public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int n = height.length; // n is not index
        int sum = 0; // total vol
        int[] left = new int[n]; // to each bar, the largest bar from left
        int[] right = new int[n];
        
        // from left to right, find the max of each bar
        left[0] = height[0];
        int maxleft = height[0];
        for(int i = 1; i < n; i++){
           left[i] = Math.max(maxleft, height[i]);
           maxleft = Math.max(maxleft, height[i]);
        }
        // from right to left
        right[n-1] = height[n-1];
        int maxright = height[n-1];
        for(int i = n - 2; i > 0; i--){
            right[i] = Math.max(maxright, height[i]);
            maxright = Math.max(maxright, height[i]);
        }
        
        // sum
        for(int i = 0; i < n; i++){
            int vol = Math.min(left[i], right[i]) - height[i];
            if(vol > 0) sum += vol;
        }
        
        return sum;
    }
}
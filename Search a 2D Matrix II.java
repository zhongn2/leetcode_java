/*
matrix search 可以考虑的方向：
1. 不局限于从左边开始搜查，这道题就是从右边开始。因为从左边搜查，要搜查的方向太多。step-wise search
2. 很像word search, 也可以考虑BFS/DFS，不过那是unordered，runtime 太大，所以在有序的时候尽量想到O(N）的解法
3. 也可以从左下角往上搜查，其实是一码事

*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        
        while(row < m && col >= 0){
            int curr = matrix[row][col];
            
            if(curr == target){
                return true;
            }else if(curr < target){
                row++;
            }else{
                col--;
            }
        }
        
        return false;
    }
}
// think about how the index changed and how to move them
// the matrix has to be oven number dimension so we need to downsize the n 2 each time


public class Solution {
    public int[][] generateMatrix(int n) {
        if(n < 0) return null;
        int[][] result = new int[n][n];
        int start = 1;
        int x = 0, y = 0;
        for(int i = n; i > 0; i -= 2){
            if(i == 1){
                result[x][y] = start;
            }else{
                //first row
                for(int j = 0; j < i - 1; j++){
                    result[x][y++] = start++;
                }
                // right down
                for(int j = 0; j < i - 1; j++){
                    result[x++][y] = start++;
                }
                // the last row from right to the left
                for(int j = 0; j < i - 1; j++){
                    result[x][y--] = start++;
                }
                // up left
                for(int j = 0; j < i - 1; j++){
                    result[x--][y] = start++;
                }
                // need to visit the middle parts
                x++;
                y++;
            }
        }
        return result;
    }
}
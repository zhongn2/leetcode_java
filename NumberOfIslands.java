/*
简单的dfs，solution 1 减少了时间复杂度，
对于 x, y 坐标的问题，可以不用调用dfs本身，而在x,y 上进行改变。
这样的话，对于X，y坐标的改变应该进行尝试，小心 continue and return 的使用
solution 2 是容易想到的解决方法

*/

public class Solution {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private int row;
    private int col;
    
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        row = grid.length;
        if(row == 0) return 0;
        col = grid[0].length;
        if(col == 0) return 0;
        int count = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j){
        grid[i][j] ='#';
        for(int k = 0; k < 4; k++){
            int nextX = i + dx[k];
            int nextY = j + dy[k];
            if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                if (grid[nextX][nextY] == '1') {
                    dfs(grid, nextX, nextY);
                }
            }
			/*
			solution 1':
			if(nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) continue;
            if(grid[nextX][nextY] == '1'){
                dfs(grid, nextX, nextY);
            }
			*/
        }
    }
}

// solution 2

public class Solution {
   private int row;
   private int col;
     
    public int numIslands(char[][] grid) {
        // Write your code here
       
        row = grid.length;
        if(row == 0) return 0;
        col = grid[0].length;
        if(col == 0) return 0;
        
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] != '1') continue;
                
                count++;
                dfs(grid, i, j);
                
            }
        }
        return count;
        
    }
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= row || j < 0 || j >= col) return;
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}
public class Solution {
    public void gameOfLife(int[][] board) {
       if(board == null || board[0].length ==0) return;
       int m = board.length;
       int n = board[0].length;
       
       int[] dx = {-1,-1,-1,0, 0,1, 1, 1};
       int[] dy = {-1,0,1,-1, 1,-1, 0, 1};
       
       for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++){
               int count = 0;
               for(int k = 0; k < 8; k++){
                   int x = dx[k] + i;
                   int y = dy[k] + j;
                   //the cell must be live or had been alive
				   //计算周围cell的时候，虽然current cell的next state计算出来并且改变了，但是
				   //current cell 的曾经的live状态对计算接下来的cell有关系，所以即使current cell
				   //被标记成了2（dead），我们还是计算的时候认定为live的cell
                   if(x >= 0 && x < m && y >= 0 && y < n &&(board[x][y] == 1 || board[x][y] == 2)){
                       count++;
                    }
               }
            // live -> dead
            if(board[i][j] == 1 && (count <2 || count > 3)){
                board[i][j] = 2;
            }
            // dead -> live
            else if(board[i][j] == 0 && count == 3){
                board[i][j] = 3;
            }     
                  
         }
     }
     for(int i = 0; i < m; i++){
         for(int j = 0; j < n; j++){
             board[i][j] %= 2;
         }
     }
       
       
    }
}
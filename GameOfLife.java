/*

我一开始就想当然的用了个二维int矩阵做参数。 
然后他memory overhead是什么，我就说我m*n*4。 
问能不能省，我就说其实不需要用int存状态，用两个bit就可以了。 
又问如果还要再省一点呢？我就说，如果要操作的点不太多的话，那就不要存矩阵了，就存存要修改的点的坐标。 
然后又问怎么做，我才意识到他是想说参数其实不必用矩阵，
就用一个list of coordinates，然后就说如果是sparse矩阵的话就只扫一下live的点，
然后看看它和它neighbor在下一轮是什么状态就好了



*/



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
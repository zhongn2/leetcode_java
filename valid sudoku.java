//rule is that check every single row
// and col and also sub-matrix
// here we use hashset to avoid duplicate
// char[][] board: row is in the first index, col is in the sec index
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int col = board[0].length;
        int row = board.length;
        
        // check col first
        for(int i = 0; i < col; i++){
            HashSet<Character> set = new HashSet<Character>();
            for(int j = 0; j < row; j++){
                if(board[j][i]!= '.'&& !set.add(board[j][i])){
                    return false;
                }
            }
        }
        //check row
        for(int i = 0; i < row; i++){
            HashSet<Character> set = new HashSet<Character>();
            for(int j = 0; j < col; j++){
                if(board[i][j]!= '.'&& !set.add(board[i][j])){
                    return false;
                }
            }
        }
        //check sub-matrix
		//每个cell里面是3*3 我们需要check，每次移动i, j 是原来的3倍
		//所以里层的指针才是board里面的参数
        for(int i = 0; i < 3;i++){
            for(int j = 0; j < 3; j++){
                 HashSet<Character> set = new HashSet<Character>();
                 for(int m = i*3; m < i*3 + 3; m++){
                      for(int n=j*3; n<j*3+3; n++){
                         if(board[m][n]!= '.' && !set.add(board[m][n])){
                             return false;
                         }
                          
                      }
                 }
            }
        }
        
        return true;
    
        
    }
}
//typical dfs search
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null) return false;
        int m = board.length; // row
        int n = board[0].length; // col
        boolean res = false;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word, i, j, 0)){
                    res = true;
                }
            }
        }
        return res;
    }
  // in order to revisit the char, we set the visited char to "#"  
    public boolean dfs(char[][] board, String word, int i, int j, int k){
        int m = board.length; // row
        int n = board[0].length; // col
        
        if(i >=m || j >= n|| i < 0 || j < 0) return false;
        
        if(board[i][j] == word.charAt(k)){
            char tmp = board[i][j];
            board[i][j] = '#';
            if(k == word.length() - 1) return true;
            else if(dfs(board,word, i-1, j, k+1) ||dfs(board,word, i+1, j, k+1)||
                dfs(board,word, i, j-1, k+1)||dfs(board,word, i, j+1, k+1)){
                    return true;
                }
            board[i][j] = tmp;
        }
        return false;
    }
}
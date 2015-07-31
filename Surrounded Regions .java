/*
	Runtime complexcity: O(m * n)
	Space complexcity: O( m + n)

*/

public class Solution {
    
    private LinkedList<Integer> queue = new LinkedList<Integer>();
    
    public void solve(char[][] board) {
      if(board==null || board.length <= 1 || board[0].length <= 1)  return; 
        
        int m = board.length;    // row
        int n = board[0].length; // col
        
        // first row
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O'){
                bfs(board, 0, i);
            }
        }
        // last row
        for(int i = 0; i < n; i++){
            if(board[m-1][i] == 'O'){
                bfs(board, m - 1, i);
            }
        }
        // first col
        for(int j = 0; j < m; j++){
            if(board[j][0] == 'O'){
                bfs(board, j, 0);
            }
        }
        //last col
         for(int j = 0; j < m; j++){
            if(board[j][n-1] == 'O'){
                bfs(board, j, n-1);
            }
        }
        // those 'o' -> 'x'
        // '#' -> 'o'
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    /*
		check the nodes near by the current node
		from four directions
		put into queue when it is an 'o'
		until search the whole board
	*/
	
    private void bfs(char[][] board, int i, int j){
        int n = board[0].length;
        // current position is 'o'
        fill(board, i, j);
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            int row = curr / n; // current row
            int col = curr % n; // current col
            
            fill(board, row, col + 1);
            fill(board, row, col - 1);
            fill(board, row + 1, col);
            fill(board, row - 1, col);
        }
    }
	/*
		fill function is used to make O -> #
		do the boundrary check and put into queue
	
	*/
    
    private void fill(char[][] board, int i, int j){
        int m = board.length;    // row
        int n = board[0].length; // col
        
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
        // we encode the position as the integers
        queue.add(i * n + j); // eg. 4th row, 4 col
        board[i][j] = '#';
    }
}
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) return result;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = 0;
        
       while(m > 0 && n > 0){
            // if the matrix is only one col or one row
            if( m == 1){
                for(int i = 0; i < n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if( n == 1){
                for(int i = 0; i < m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }
            // top 
            for(int i = 0; i < n - 1; i++){
                result.add(matrix[x][y++]);
            }
            // right 
            for(int i = 0; i < m -1; i++){
                result.add(matrix[x++][y]);
            }
            //down
            for(int i = 0; i < n -1; i++){
                result.add(matrix[x][y--]);
            }
            // up
            for(int i = 0; i < m - 1; i++){
                result.add(matrix[x--][y]);
            }
            x++;
            y++;
            m -= 2;
            n -= 2;
       }
            
return result;   
        
    }
}
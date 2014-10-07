// constant space
// using the first row and first col to record whether there is is 0 in position
// have to record the status that whether the first row or col has 0 already


public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean zero_row = false;
        boolean zero_col = false;
        // search for the first col, check if there is 0 
       for(int i = 0; i < row; i++){
           if(matrix[i][0] == 0){
               zero_col = true;
               break;
           }
       }
       // search for the first row
         for(int i = 0; i < col; i++){
           if(matrix[0][i] == 0){
               zero_row = true;
               break;
           }
       }
       // set the first element in row and col zero
       for(int i = 1; i < row; i++){
           for(int j = 1; j < col; j++){
               if(matrix[i][j] == 0){
                   matrix[i][0] = 0;
                   matrix[0][j] = 0;
           }
        }
      }
       // set the whole row and col to be zero
        for(int i = 1; i < row; i++){
           for(int j = 1; j < col; j++){
               if(matrix[i][0] == 0 || matrix[0][j] == 0){ // not && 
                   matrix[i][j] = 0;
               }
           }
        }
        if(zero_row){
            for(int i = 0; i < col; i++){
                matrix[0][i] = 0;
            }
        }
        if(zero_col){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
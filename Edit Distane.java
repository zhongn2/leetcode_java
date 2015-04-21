// about the string, be caredful about the corner, the boundry
// 'a'
// 'b'
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dis = new int[m+1][n+1];
        
        for(int i = 0; i < m + 1; i++){
            dis[i][0] = i;
        }
        for(int j = 0; j < n + 1; j++){
            dis[0][j] = j;
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dis[i][j] = dis[i-1][j-1];
                }else{
                    dis[i][j] = Math.min(dis[i-1][j-1], Math.min(dis[i][j-1],dis[i-1][j])) + 1;
                }
            }
        }
        return dis[m][n];
  
    }
}
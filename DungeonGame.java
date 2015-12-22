/*
这题就是bottom-up的DP，
有一个限制条件就是进入某一点dp[i][j]， 如果它的value是负数，那么我们至少需要-dp[i][j] + 1 的体力，
如果是正数，那么我们只需要1的体力。
我们的目的是要找到最小值。
初始化数组： 赋值为MAX_VALUE,然后dp[m][n-1] = dp[m-1][n] = 1,相当于底端的左边和上端的点。
从最底端递归，int value = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
比较value和 0的关系

*/



public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0){
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n-1] = 1; dp[m-1][n] = 1;
        
        for(int i = m -1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int tmpHP = Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j];
                dp[i][j] = (tmpHP <= 0) ? 1 : tmpHP;
            }
        }
        return dp[0][0];
    }
}
//Longest Palindromic Substring
//很经典的DP问题，这道题还需要record起点和终点，然后每次更新最长长度
// dp[i][j] = dp[i-1][j+1] if s[i] == s[j]
// i 和 j 的限制条件 j - i <2

public String longestPalindrome(String s){
	if(s.length() == 0 || s == null) return "";
	int len = s.length();
	boolean[][] dp = new boolean[len][len];
	//initialization
	for(int i = 0; i < len; i++){
		dp[i][i] = true;
	}
	int start = 0, end = 0, maxLength = 1;
	
	for(int i = len - 1; i >= 0; i--){
		for(int j = i; j < len; j++){
			if(dp[i+1][j-1] == true || j - i < 2){
				if(s.charAt(i) != s.charAt(j)){
					continue;
				}
				dp[i][j] = true;
				if( j - i + 1 > maxLength){
					maxLength = j - i + 1;
					start = i;
					end = j;
				}
			}
		}
	}
	return s.substring( start, end + 1);
}


or 
if(s.charAt(i) == s.charAt(j)){
        			dp[i][j] = true;
        			if( j - i + 1 > maxLength){
        				maxLength = j - i + 1;
        				start = i;
        				end = j;
        			}
				
	




}
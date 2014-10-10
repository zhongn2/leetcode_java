//Longest Palindromic Substring
//很经典的DP问题，这道题还需要record起点和终点，然后每次更新最长长度
// dp[i][j] = dp[i-1][j+1] if s[i] == s[j]
// i 和 j 的限制条件 j - i <2
// run complexcity: O(n ^ n). space complexcity : O(n ^ n)
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
//从中间向两边发散，比如 b a b, 我们可以check a 左右两边的字符串
// 另一种情况是中间是两个字符 例如 b a a b, a a之间本身就是相同的。只有以上两种情况

public class Solution {
   public String longestPalindrome(String s){
	if(s.length() == 0 || s == null) return "";
	String result = s.substring(0, 1);
	for(int i = 0; i < s.length() - 1; i++){
		String one = longestL(s, i, i);
		if(one.length() > result.length()){
		    result = one;
		}
		String two = longestL(s, i, i+1);
			if(two.length() > result.length()){
		    result = two;
		}
	}
	return result;
}
private String longestL(String s, int i, int j){
	int left = i;
	int right = j;
	while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
		left --;
		right++;
	}
	return s.substring(left + 1, right);
}
}
		

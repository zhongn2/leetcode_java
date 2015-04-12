// f[j] = min(f[i-1] + 1) if s[i][j] is a palindrome
// s[i][j] = s[i+1][j-1] if s[i] == s[j]

public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] cut = new int[n];
        
        for(int j = 0; j < n; j++){
            cut[j] = j;
            for(int i = 0; i <= j; i++){
				// a palindrome could be three forms :a, aa, aba
				// j - i <= 1 is used to identify the aa and a
                if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPalindrome[i + 1][j - 1])){
                    isPalindrome[i][j] = true;
                    if(i > 0){
                        cut[j] = Math.min(cut[j], cut[i-1] + 1);
                    }else{
                        cut[j] = 0;
                    }
                }
            }
        }
        return cut[n-1];
    }
}
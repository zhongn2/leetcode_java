/* 先制作原字符串的对称镜像字符串，如s = "abcd", 镜像a = "abcddcba"。

然后对新字符串a，按KMP算法求Prefix的方法，求Prefix, 得【0， 0， 0， 0， 0，  0， 0， 1】，
然后s.length() - prefix[2 * s.length()-1] 即为需要复制到s前的s尾部字符串的个数。 */


public class Solution {  
    public String shortestPalindrome(String s) {  
        String result = "";  
        if(s.length() == 0)  
            return result;  
        int[] prefix = new int[s.length() * 2];  
        String mirror = s + new StringBuilder(s).reverse().toString();  
        for(int i = 1; i < s.length() * 2; i++) {  
            int j = prefix[i-1];  
            while(mirror.charAt(j) != mirror.charAt(i) && j > 0)  
                j = prefix[j-1];  
            if(mirror.charAt(i) == mirror.charAt(j))  
                prefix[i] = j + 1;  
            else  
                prefix[i] = 0;  
        }  
        int count = s.length() - prefix[s.length() * 2 -1];  
        result = new StringBuilder(s.substring(s.length()-count, s.length())).reverse().toString() + s;  
        return result;  
    }  
}  
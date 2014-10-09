public class Solution {
    //两重循环，首先肯定原string对于mask有n-m+1个可能性
    // 一层循环是给mask比较长度
    //另外一层循环是必须iterate原string，找到第一位和Mask相同的字符
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return null;
        }
        int i, j;
        for(i = 0; i < haystack.length() - needle.length() + 1; i++){
            for(j = 0; j < needle.length(); j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
            }
            if(j == needle.length()){
                return haystack.substring(i);
            }
            
        }
        return null;
        
    }
}
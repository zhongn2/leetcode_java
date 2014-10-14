public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            prefix = prefixHelper(prefix, strs[i]);
        }
        return prefix;
    }
    private String prefixHelper(String p, String input){
        String rst = "";
        int m = p.length() < input.length()? p.length() :input.length();
        int i = 0;
        while(i < m){
            if(p.charAt(i) == input.charAt(i)){
                rst += p.charAt(i);
                i++;
            }else{
                break;
            }
        }
        return rst;
    }
}
/*
 这道题的思路在于每次需要改变res的值
 通过count来记录

*/


public class Solution {
    public String countAndSay(int n) {
        if(n < 0) return "";
        String res = "1";
        
        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
			//这部分相当于从左往右扫，但是不包括最后index
            for(int j = 1; j < res.length(); j++){
                if(res.charAt(j) == res.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count).append(res.charAt(j-1));
                    count = 1;
                }
            }
           // use res.length() - 1 to get the last index
            sb.append(count).append(res.charAt(res.length() - 1)); 
            res = sb.toString();
        }
        return res;
        
    }
}
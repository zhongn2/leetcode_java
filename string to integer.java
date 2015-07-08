/*
corner cases:
1. sign = 1 / -1;
2. INT_MAX AND INT_MIN
3. convert long to int at the end


*/



public class Solution {
    public int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.length() == 0) return 0;
        
        int index = 0;
        int sign = 1;
        long num = 0;
        
        if(str.charAt(index) == '+') index++;
        else if(str.charAt(index) == '-') { index++; sign = -1;}
        
        for(;index < str.length(); index++){
            if(str.charAt(index) < '0' || str.charAt(index) > '9') break;
            num = num * 10 + (str.charAt(index) - '0');
            if(num > Integer.MAX_VALUE){
               break;
            }
        }
        if(num * sign >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(num * sign <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int) num * sign;
    }
}
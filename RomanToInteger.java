/*
	罗马数字变成整形
	如果后面的数字比前面的大，则视为减
	http://blog.csdn.net/wzy_1988/article/details/17057929
*/


public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int i, pre, curr, sum;
        sum = RomanTable(s.charAt(0));
        
        for(i = 1; i < s.length(); i++){
            pre = RomanTable(s.charAt(i-1));
            curr = RomanTable(s.charAt(i));
            
            if(curr <= pre){
                sum += curr;
            }else{
                sum = sum + curr - 2*pre;
            }
        }
        
        return sum;
    }
    
    public int RomanTable(char c){
        int num = 0;
    
        switch(c){
            case 'I': num = 1; break;
            case 'V': num = 5; break;
            case 'X': num = 10; break;
            case 'L': num = 50; break;
            case 'C': num = 100; break;
            case 'D': num = 500; break;
            case 'M': num = 1000; break;
        }
        
        return num;
    }
}
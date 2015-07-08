/*
this problem is simple compared with multiple string
we don't need extra array to store the result when conducting an operation
and also bit-bit process the binary 
attention:
it is a way to reverse the string first and then do the operation as well



*/


public class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        String res = "";
        int maxLen = Math.max(aLen, bLen);
        int carry = 0;// carry will be update in each iteration
        
        for(int i = 0; i < maxLen; i++){
            int currA = 0;
            int currB = 0;
            
            if(i < aLen){
                currA = a.charAt(aLen - 1 - i) - '0';
            }else{
                currA = 0;
            }
             if(i < bLen){
                currB = b.charAt(bLen - 1 - i) - '0';
            }else{
                currB = 0;
            }
           int tmp = currA + currB + carry;
           carry = tmp / 2;
           res = tmp % 2 + res;
        }
        // the final result could be more than the maxlen
        return (carry == 0) ? res : "1" + res ;
        
    }
}
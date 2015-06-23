public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
           return Integer.MAX_VALUE ? dividend >= 0 :  Integer.MIN_VALUE;
        }
        if(dividend == 0){
            return 0;
        }
        boolean isNeg = (dividend < 0 && divisor > 0) ||
                        (dividend > 0 && divisor < 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
		// shift right = *２
		// here we try to calculate how many times we need to shift the divisor
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){
                shift++;
            }
            a -= b <<(shift-1);
            result += 1 << (shift -1);
        }
        return isNeg ? -result :result;
        
        
    }
}
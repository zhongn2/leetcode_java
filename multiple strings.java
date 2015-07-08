// if we just use int to multiple, the result would overflow
// I think about long-int, but it's still cant guarntee that
// so the best way is to do bit-by-bit 
//reverse the string first and starts from end
// trim '0' at the end
public class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int len1 = num1.length();
        int len2 = num2.length();
        int[] mul = new int[len1 + len2];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < len1; i++){
            int a = num1.charAt(i) - '0';
            for(int j = 0; j < len2; j++){
                int b = num2.charAt(j) -'0';
                mul[i+j] += a * b;
            }
        }
        
        for(int k = 0; k < mul.length; k++){
            int digit = mul[k] % 10;
            int carry = mul[k] / 10;
            
            if(k+1 < mul.length){
                mul[k+1] += carry;
            }
            sb.insert(0, digit);
        }
        // trim the situation that 0 exists
        while(sb.charAt(0) == '0' && sb.length() > 1){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
        
    }
}
//Excel Sheet Column Title 
// C++ allow string + char
class Solution {
public:
    string convertToTitle(int n) {
         if(n == 0) return "";
        
        return convertToTitle((n-1) / 26) + char((n-1) % 26 + 'A');
    }
};

// Java has no string primitive type
// so we use stringbuilder to construct and then reverse the string
public class Solution {
    public String convertToTitle(int n) {
        if(n == 0) return "";
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            n--;
            char c = (char)((n % 26) + 'A');
            n /= 26;
            sb.append(c);
        }
        sb.reverse();
        return sb.toString();
        
    }
}
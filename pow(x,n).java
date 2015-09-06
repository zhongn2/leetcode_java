public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 0) return 0;
        if(n < 0) {
            x = 1 / x;
            n = -n;
        } // change x and n right here
        
        double temp = myPow(x, n /2);
        
        return (n % 2 == 0) ? temp * temp : temp * temp * x;
    }
}
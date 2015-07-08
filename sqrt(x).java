
// simple binary search 

public class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        long l = 0;
        long r = x;
        
        while(l <= r){
            long mid = l + (r - l) / 2;
            if(mid * mid == x){
                return (int)mid;
            }
            else if(mid * mid > x){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return (int)r;
    }
}
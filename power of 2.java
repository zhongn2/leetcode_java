/*
如果一个数是2的幂，那么二进制表达应该是第一位为1，其他都为0
所以我们将 n & (n -1) 结果肯定为0
*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0 && n > 0;
    }
}

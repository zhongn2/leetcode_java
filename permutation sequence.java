public class Solution {
    public String getPermutation(int n, int k) {
         ArrayList<Integer> dict = new ArrayList<Integer>();
        String rs = "";
        k = k - 1;
        for (int i = 1; i <= n; i++) {
            dict.add(i);
        }
        for (int i = 1; i < n; i++) {
            int a = k / factorial(n - i);
            k = k % factorial(n - i);
            rs += dict.get(a);
            dict.remove(a);
        }
        rs += dict.get(0);
        return rs;
    }
    
    public int factorial(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    
    }
}
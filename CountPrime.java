
/*
 某一个算法：一组boolean数组，从2开始，k = j*j; k+= j,将数组对应的赋值为false

*/
public class Solution {
    public int countPrimes(int n) {
       if(n <= 2) return 0;
       boolean[] primes = new boolean[n];
       for(int i = 2; i < primes.length; i++){
           primes[i] = true;
       }
       for(int j = 2; j <= Math.sqrt(n - 1); j++){
           if(primes[j]){
               for(int k = j * j; k < n; k += j){
                   primes[k] = false;
               }
           }
       }
       int result = 0;
       for(int i = 0; i < primes.length; i++){
           if(primes[i]){
               result++;
           }
       }
       return result;
       
    }
}
public class Solution {
    public int findMin(int[] num) {
          if(num == null || num.length == 0) return Integer.MIN_VALUE;
          int result = num[0];
          int low = 0; 
          int high = num.length - 1;
          while(low <= high){
              int mid = (low + high) / 2;
			  while(num[mid] == num[low] && mid != low) low ++; // leave the duplicated numbers
			  while(num[mid] == num[high] && mid != high) high--;// the same at the end of the roteted array
              if(num[mid] <= num[high]){
                  high = mid - 1;
              }else{
                  low = mid + 1;
              }
             result = Math.min(result, num[mid]); 
          }
          return result;
          
    }
}
// need O(n) runtime
// we can come up with hashset, the delete, add function needs constant time
// we only need to iterate the num array once

public class Solution {
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int maxLength = 1;
        
        for(int number :num){
            set.add(number);
        }
        for(int n : num){
            int left  = n - 1;
            int right = n + 1;
            int count = 1;
            while(set.contains(left)){
                set.remove(left);
                left--;
                count++;   
            }
            while(set.contains(right)){
                set.remove(right);
                right++;
                count++;
            }
			maxLength = Math.max(maxLength, count);
        }  
        return maxLength;
    }
}
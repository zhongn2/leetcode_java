public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 3){
            return result;
        }
        Arrays.sort(num); // sort the array first
        int len = num.length;
        
        for(int i = 0; i < len - 2; i++){
            // remove duplicate
            if(i != 0 && num[i] == num[i - 1]){ // we need to compare the curr element with previous element
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                int sum = num[i] + num[left] + num[right];
                if(sum == 0){
                     ArrayList<Integer> tmp = new ArrayList<Integer>();
                     tmp.add(num[i]);
                     tmp.add(num[left]);
                     tmp.add(num[right]);
                     result.add(tmp);
                     left++;
                     right--;
                     // when we visit the element inside, it would have duplicate
                     // we have change left and right, so new left element should compare with the previous one
                     // we use the while loop to escape the dups
                     while(left < right && num[left] == num[left-1]){
                         left++;
                     }
                     while(left < right && num[right] == num[right+1]){
                         right--;
                     }
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
            
        }
        return result;
    }
}
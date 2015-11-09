public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length == 0 || nums == null) return res;
        int count1 = 0;
        int count2 = 0;
        int candidate1 = -1;
        int candidate2 = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(candidate1 == nums[i]){
                count1++;
            }else if(candidate2 == nums[i]){
                count2++;
            }else if(count1 == 0){
                candidate1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }
        }
        if(count1 > nums.length / 3){
            res.add(candidate1);
        }
        if(count2 > nums.length / 3){
            res.add(candidate2);
        }
        
        return res;
    }
        
}
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null) return res;
        int start = 0;
        int end = 0;
        
        while(end < nums.length){
            if(end + 1 < nums.length && nums[end + 1] == nums[end] +1){
                end++;
            }else{
                if(start == end){
                    res.add(Integer.toString(nums[end]));
                }else{
                    String s = nums[start] + "->" + nums[end];
                    res.add(s);
                }
                end++;
                start = end;
            }
        }
        return res;
       
        
    }
}
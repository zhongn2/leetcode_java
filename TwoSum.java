/*
    一般来说，和index有关，很可能和hashmap有关系，比较容易查找
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length == 0 || nums == null) return res;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int key = target - nums[i];
            
            if(!map.containsKey(key)){
                map.put(nums[i], i);
            }else{
                res[0] = map.get(key) + 1;
                res[1] = i + 1;
                break;
            }
        }
        
        return res;
    }
}

//  FOLLOW UP 1: Two Sum II - Input array is sorted
// 排好序的数组，就是告诉我们找两个数，加起来等于target，双指针问题
 int left = 0;
 int right = nums.length -1;
 while(left < right){
	  == T return new int[]{left + 1, right + 1};
	  > T right --;
	  < T left ++;
 }
 
 // FOLLOW UP 2: 
 /*
 Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
 */
 // 关键在于重复的值怎么判断，
 public class TwoSum {
	 
	 private Map<Integer, Integer> map;
	 
	 public TwoSum(){
		 map = new HashMap<Integer, Integer>();
	 }
	 
	 public void add(int num){
		 if(map.containsKey(num)){
			 map.put(num, map.get(num) + 1);
		 }else{
			 map.put(num, 1);
		 }
	 }
	 public boolean find(int target){
		 if(num == null) return false;
		 
		 for( int key : map.keySet()){
			 int rest = target - key;
			 // share the same value
			 if(rest == key && map.get(key) > 1){
				 return true;
			// different value
			 }else if(rest != key && map.containsKey(rest)){
				 return true;
			 }
		}
		return false;
	 }			
	 
	 
	 
 }
	 
	 
	 
 


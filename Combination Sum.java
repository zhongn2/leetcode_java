//Combination Sum

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        if(candidates == null || candidates.length == 0){
            return result;
        }
        comSumhelper(candidates, target, result, path, 0);
        return result;
    }
    public void comSumhelper(int[] cans, int target, List<List<Integer>> result,  ArrayList<Integer> path, int pos){
        if(target == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = pos; i < cans.length; i++){
            if(target < cans[i]){
                break;
            }
			// sum 2 is to avoid the duplicate num
			 if(i != pos && cans[i] == cans[i-1]){
               continue;
           }
            path.add(cans[i]);
            comSumhelper(cans, target - cans[i], result, path, i);
            path.remove(path.size() - 1);
            
        }
    }
}
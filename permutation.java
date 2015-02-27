// permutation problem
// the main idea is just the same,
// we used iteration method to go through the num sets
// the difference is that permutation does not need to add or change items
// we just need to check if the num is in the path or not and the subsets things are need to add each item into the path set 
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
         ArrayList<Integer> path = new ArrayList<Integer>();
         if(num == null || num.length == 0){
             return result;
         }
         permuteHelper(result, path, num);
         return result;
    }
    public void permuteHelper( List<List<Integer>> result,  ArrayList<Integer> path, int[] num){
        if(path.size() == num.length){
            result.add(new ArrayList<Integer>(path));
        }
        for(int i = 0; i < num.length; i++){
			// check the num has been visited or not
            if(path.contains(num[i])){
                continue;
            }
            path.add(num[i]);
            permuteHelper(result, path, num);
            path.remove(path.size()- 1);
        }
    }
}


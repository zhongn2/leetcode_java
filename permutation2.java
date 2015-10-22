
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
         ArrayList<Integer> path = new ArrayList<Integer>();
         int[] visited = new int[num.length];
         Arrays.sort(num);
         if(num == null || num.length == 0){
             return result;
         }
         permuteHelper(result, path, num, visited);
         return result;
    }
    public void permuteHelper( List<List<Integer>> result,  ArrayList<Integer> path, int[] num, int[] visited){
        if(path.size() == num.length){
            result.add(new ArrayList<Integer>(path));
        }
        for(int i = 0; i < num.length; i++){
            // we need to start from the second place
            if(visited[i] == 1 ||(i > 0 && num[i] == num[i-1] && visited[i-1] == 0)){
                continue;
            }
            visited[i] = 1; // visited
            path.add(num[i]);
            permuteHelper(result, path, num,visited);
            path.remove(path.size()- 1);
            visited[i] = 0; // unvisited
        }
    }
}

//solution 2

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		returnList.add(new ArrayList<Integer>()); // result
	 
		for (int i = 0; i < nums.length; i++) { // a loop
		
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			// l 这里需要remove 每次加入的num
			//比如 num = {1, 1, 2, 3}; 加入第一个num 1后，每次尝试加入剩下的数
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, nums[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<List<Integer>>(currentSet);
		}
	 
		return returnList;
		}
}


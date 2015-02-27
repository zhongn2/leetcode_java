
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


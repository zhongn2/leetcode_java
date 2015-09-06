/* 整体思路和之前做的差不多
方法一采取的是BFS，思考如下：
1. 如何对pair数据进行处理？ 这里我们用了hashmap 装了每个课程（key)，和与它相关的其他课程(value)
2. 首先找到独立的课程，即该课程的入度为0
3. bfs, 将独立课程从queue中移除，同时与之相关的课程的入度-1，如果变成了0，又加入到queue中
4. check是否所有的课程的入度都为0

如果加强成OOD的设计
course 就相当于graph node，可以被封装
 */

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1 || prerequisites == null || prerequisites.length == 0){
            return true;
        }
        int[] course = new int[numCourses]; // incoming degree, find the sink vertex
        Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i <prerequisites.length; i++){
            int key = prerequisites[i][1];
            int val = prerequisites[i][0];
            
            if(!graph.containsKey(key)){
                graph.put(key, new ArrayList<Integer>());
            }
            graph.get(key).add(val);
            course[val]++; 
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(course[i] == 0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            if(graph.get(curr) != null){
                for(int tmp : graph.get(curr)){
                    course[tmp]--;
                    if(course[tmp] == 0){
                        q.offer(tmp);
                    }
                }
            }
        }
        
        for(int i = 0; i < numCourses; i++){
            if(course[i] != 0){
                return false;
            }
        }
        
        return true;
    }
}

// solution 2 
// using dfs http://blog.welkinlan.com/2015/05/09/course-schedule-leetcode-java-dfs/

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //construct graph matrix
        int[][] matGraph = new int[numCourses][numCourses];
        for (int i = 0; i< prerequisites.length; i++) {
            matGraph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        int[] visited = new int[numCourses]; //0 / 1 / 2: not visited / visiting / visited
        //detect cycle in each connected component
        for (int node = 0; node < numCourses; node++) {
            if (visited[node] == 0){
                if (DFS(node, matGraph, visited)) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    
    public boolean DFS(int node, int[][] matGraph, int[] visited) {
        visited[node] = 1; //1: visiting
        for (int otherNode = 0; otherNode < matGraph.length; otherNode++) {
            if (matGraph[node][otherNode] == 1) {
                if (visited[otherNode] == 1) {
                    //cycle
                    return false;
                }
                if (visited[otherNode] == 0 && !DFS(otherNode, matGraph, visited)) {
                    return false;
                }
            }
        }
        visited[node] = 2; //2: visit done
        return true;
    }
}
/*
 * topo sort is used in the grpah
 * each node relies on the previous node
 * we use BFS to search for each node 
 * @params: inCount 表示的是每个点的入度
 * 			outCount 表示的是每个点的初度
 * 算法核心：找到入度为0的每个点，然后继续BFS，去找到该点block的其他的点，然后让其他的点的入度-1
 * 		 如果该点的入度为0了，就把该点加入到队列里面，所以队列里面的元素就是拓扑排序的顺序，如果为空
 *		 说明不存在拓扑排序
 * 
 * 
 * 
 */
public class toposort {
	
	class DirectedGraphNode {
		      int label;
		      ArrayList<DirectedGraphNode> blocks;
		      DirectedGraphNode(int x) { label = x; blocks = new ArrayList<DirectedGraphNode>(); }
		  };
		  
		  public ArrayList<DirectedGraphNode> topoSort(ArrayList<DirectedGraphNode> graph) {
			  // result is for the  toposort and incount is used to calculate the node's in degree
			  ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
			  Map<DirectedGraphNode, Integer> inCount = new HashMap<DirectedGraphNode, Integer>();
			  
			  //construct inCount (contains neighbors only, which means the in degree would always >= 1)
			  for(DirectedGraphNode node : graph){
				  for(DirectedGraphNode neigh : node.blocks){
					  if(inCount.containsKey(neigh)){
						 inCount.put(neigh, inCount.get(neigh) + 1);
					  }else {
						inCount.put(neigh, 1);
					}
				  } 
			  }
			  
			  // BFS, find the node with indegree 0
			  Queue<DirectedGraphNode> Q = new LinkedList<DirectedGraphNode>();
			  
			  for(DirectedGraphNode node : graph){
				  if (!inCount.containsKey(node)) {
					  Q.offer(node);
					  result.add(node);
				}
			  }
			  
			  // search every node in the Q
			  // deduct 1 from the neigh nodes and check whether the neigh node is valid to add 
			  // into Q and result
			  while(!Q.isEmpty()){
				  DirectedGraphNode first = Q.poll();
				  for(DirectedGraphNode node : first.blocks){
					  inCount.put(node, inCount.get(node) - 1);
					  
					  if(inCount.get(node) == 0){
						  Q.offer(node);
						  result.add(node);
					  }
				  }
			  }
			  
			  return result;
		  }

}
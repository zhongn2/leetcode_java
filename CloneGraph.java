/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 * 使用arrayList代替queue是因为存的node在接下来里仍然使用，所以用了一个start来记录size
 *
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
         if(node == null) return null;
			  
			  ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
			  Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
			 // clone first node
			  nodes.add(node);
			  map.put(node, new UndirectedGraphNode(node.label));
			  
			  // bfs starts here
			  // iterate neigh nodes, update map and add neigh nodes into "nodes"
			  int start = 0;
			  while(start < nodes.size()){
				  UndirectedGraphNode head = nodes.get(start++);
				  
				  for(int i = 0; i < head.neighbors.size(); i++){
					  UndirectedGraphNode neighGraphNode = head.neighbors.get(i);
					  if(!map.containsKey(neighGraphNode)){
						  map.put(neighGraphNode, new UndirectedGraphNode(neighGraphNode.label));
						  nodes.add(neighGraphNode);
					  }
				  }
			  }
			  
			  // copy neigh nodes, it has to be the newbuilt node, which
			  for (int i = 0; i < nodes.size(); i++) {
				  UndirectedGraphNode newGraphNode = map.get(nodes.get(i));
				  
				  for(int j = 0; j < nodes.get(i).neighbors.size(); j++){
					  newGraphNode.neighbors.add(map.get(nodes.get(j).neighbors.get(j)));
				  }
			}
			  return map.get(node);
		  
    }
}
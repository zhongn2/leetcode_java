public enum State{
	visited,  unvisited; // three states to mark each node
}
public boolean BFS(Graph g, Node start, Node end){
	Queue<Node> queue = new Queue<Node>();
	for(Node u : g.getneighbours()){
		u.state = State.unvisited;
	}
	
	queue.add(start);
	Node node;
	while(!queue.isEmpty()){
		node = queue.poll();
		if(node != null){
			for(Node n : node.getAdjacent()){
				if(n.state == n.visited){
					if(n == end){
						return true;
					}else{
						n.state = visited; // mark 
						queue.add(n);
					}
				}
			}
		}
		node.state  = visited;
	}
}
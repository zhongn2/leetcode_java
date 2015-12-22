public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		  List<Integer> leaves = new ArrayList<>();
		  if (n <= 1) {
			leaves.add(0);
			return leaves;
		  }
		  Map<Integer, Set<Integer>> graph = new HashMap<>();
		  for(int i = 0; i < n; i++){
			  graph.put(i, new HashSet<Integer>());
		  }
		  for(int[] edge : edges){
			  graph.get(edge[0]).add(edge[1]);
			  graph.get(edge[1]).add(edge[0]);
		  }
		  // find all leaves with size == 1
		  for (int i = 0; i < n; i++) {
			if (graph.get(i).size() == 1) {
				leaves.add(i);
			}
		}
		  while(n > 2){
			  List<Integer> newleaves = new ArrayList<>();
			  for(int leaf : leaves){
				  for(int adjacent : graph.get(leaf)){
					  graph.get(leaf).remove(adjacent);
					  graph.get(adjacent).remove(leaf);
					  n--;
					  if (graph.get(adjacent).size() == 1) {
						newleaves.add(adjacent);
					}
				  }
			  }
			  leaves = newleaves;
		  }
		   
		  return leaves;
		  
	  }
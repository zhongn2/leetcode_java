 public static List<List<Integer>> zigzagtraversal(TreeNode root){
			 List<List<Integer>> res = new ArrayList<List<Integer>>();
			 if (root == null) {
				return res;
			}
			 Queue<TreeNode> queue = new LinkedList<>();
			 queue.add(root);
			 int count = 0;
			 
			 while(!queue.isEmpty()){
				 int size = queue.size();
				 ArrayList<Integer> level = new ArrayList<>();
				 
				 for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
				
					if (count % 2 == 0) {
						level.add(node.val);
					}else {
						level.add(0, node.val);
					}
					
					if (node.left != null) {
						queue.add(node.left);
					}
					if (node.right != null) {
						queue.add(node.right);
					}
				}
				// 一个for循环就是一层，考虑到arraylist可以从index加，所以就比较方便了。
				
				
				 count++;
				 res.add(level);
			 }
			 return res;
			 
		 }
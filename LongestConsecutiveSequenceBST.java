	//典型的DFS，迭代的对象分清楚就可以了。runtime：O(N)
		
		private static int max = 0;
	    public static int longestSequenceBST(TreeNode root) {
	    	if (root == null) {
				return 0;
			}
	    	DFS(root, 0, root.val);
	    	
	    	return max;
			
		}
	    // recursion: compare each node's value whether is equal == parent's value + 1
	    private static void DFS(TreeNode root, int num, int node_value) {
			// TODO Auto-generated method stub
	    	if (root == null) {
				return;
			}
	    	
	    	if (root.val == node_value) {
				num++;
			}else {
				num = 1;
			}
	    	//update max
	    	max = Math.max(max, num);
	    	
	    	DFS(root.left, num, root.val + 1);
	    	DFS(root.right, num, root.val + 1);
		}
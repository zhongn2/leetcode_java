/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
		// queue is abstract, has to be linkedlist
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
			// here level is temporary, it needs to be initialized every time
            ArrayList<Integer> level = new ArrayList<Integer>();
            int Qsize = q.size();
            for(int i = 0; i < Qsize; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                 if(node.right != null){
                    q.add(node.right);
                }
            }
            res.add(level);
        }
      
        return res;
        
    }
}
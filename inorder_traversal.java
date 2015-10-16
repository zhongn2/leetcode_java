/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //left- pop- right, use a node instead of root itself
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
        
    }
}
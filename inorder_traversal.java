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

//preoder traversal
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<Integer>();
        if(root == null) return tree;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            tree.add(top.val);
            
            if(top.right != null) stack.push(top.right);
            if(top.left != null) stack.push(top.left);
            
        }
        return tree;
        
        
    }
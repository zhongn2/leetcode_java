/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* how to visit the right child?
*   the idea is to check whether the top of the stack has the right child
*   so node is used to iterate the whole tree
*   we need to update the node to the stack.peek();
*/ 
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<Integer>();
        if(root == null) return tree;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root; // don't modify root itself
        
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
           node = stack.peek();
           stack.pop();
           tree.add(node.val);
           node = node.right;
        }
        return tree;
    }
}
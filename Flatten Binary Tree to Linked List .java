/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
	左孩子的最后一个孩子指向右孩子
 
 */
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        
        if(root.left == null) return;
        TreeNode node = root.left;
        while(node.right != null){
            node = node.right;
        }
        
        node.right = root.right;
        root.right = root.left;
        root.left = null;
        
    }
}
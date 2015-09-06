/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    public boolean isValid(TreeNode root, double low, double high){
        if(root == null) return true;
        if(root.val > low && root.val < high){
            return isValid(root.left, low, root.val) && isValid(root.right, root.val, high);
        }
        return false;
      
    }
}

// solution 2
public class Solution {
    TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    public boolean inorder(TreeNode root){
        if(root == null){
            return true;
        }
        if(!inorder(root.left)){
            return false;
        }
        if(prev != null){
            if(root.val <= prev.val){
                return false;
            }
        }
        prev = root;
        if(!inorder(root.right)){
            return false;
        }
        return true;
    }
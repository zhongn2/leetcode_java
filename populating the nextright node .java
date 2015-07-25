/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 /*
  the important thing here is that
  how we connect the right child in the left subtree
  to the left child in the right subtree
 
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null || root.right == null){
            return;
        }
		
        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        connect(root.left);
        connect(root.right);
        
    }
}
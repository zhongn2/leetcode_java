/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 // the first idea should be come up with the recursion part
 // need to think about the left and right side for a node and then it is completed
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null || root.right == null){
            return;
        }
        // the first level
        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        connect(root.left);
        connect(root.right);
        
    }
}
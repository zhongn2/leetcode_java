/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 /* 
 做题的思想还是每一层遍历，不同的点在于我们不知道是否存在左孩子和右孩子
 所以每一层用一个dummy node作为头，然后用curr遍历，将next指针赋值
 最后外层的遍历是移动dummy.next 指针，iter = dummy.next */
 
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        TreeLinkNode iter = root;
        
        while(iter != null){
            TreeLinkNode curr = iter;
            
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode node = dummy;
           
            while(curr != null){
                if(curr.left != null){
                    node.next = curr.left; // level traversal
                    node = curr.left; // move
                }
                
                if(curr.right != null){
                    node.next = curr.right;
                    node = curr.right;
                }
                
                curr = curr.next;
            }
            
            iter = dummy.next;
        }
    }
}
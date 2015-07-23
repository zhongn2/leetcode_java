/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // actually it is an inorder traversal
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;
        TreeNode node = root;
        
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            TreeNode top = stack.pop();
            if(--k == 0){
              return top.val;
            }
           node = node.right;
       
    }
}

// follow up: change the structure of the treenode
/*
	添加一个属性，去记录left child的值。
	当前节点设置为node
	如果K = leftchildCt + 1，证明root就是要找的值;
	如果K > leftchildCt + 1，说明在右子树， K = K - （leftchildCt + 1）， node = node. right;
	最后的情况就是在左子树，node = node.left;

*/
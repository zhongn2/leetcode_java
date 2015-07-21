/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // solution 1: use recursion
 // we apply on left tree 
public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root){
		if(root == null) return null;
		TreeNode parent = root, oldleft = root.left, oldright = root.right;
		
		if(oldleft != null){
			TreeNode newroot = UpsideDownBinaryTree(oldleft);
			newroot.right = parent;
			newroot.left = oldright;
			return newroot;
		}
		return root;  
    }
}

// solution 2 iteration
/*
	我们每次访问都是从左侧开始
	node的作用是用来遍历
	parent实际上记录的是每次访问节点的原parent node

*/
public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root){
		if(root == null) return null;
		TreeNode node = root, parent = null, newRight = null;
		
		while( node != null){
			TreeNode tmp = node.left;	// 存下左侧信息
			node.left = newRight;		// 更新左侧
			newRight = node.right;
			node.right = parent;		// 更新右侧
			parent = node;				// 记录当年节点的父节点
			node = tmp;					// 往左侧移动
		}
		return parent; // parent will be the most left leaf node
	}
		
}

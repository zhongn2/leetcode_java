/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // recursive solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
         if (root == null) {
				return true;
			}
			 return isSameTree(root.left, root.right);
		 }

		private static boolean isSameTree(TreeNode left, TreeNode right) {
			if (left == null && right == null) {
				return true;
			}
			if (left == null || right == null) {
				return false;
			}
			if (left.val == right.val) {
				return isSameTree(left.left, right.right) &&isSameTree(left.right, right.left);
			}
			return false;
		}
}
// iterative solution
		if(root == null) return true;
		Queue<TreeNode> leftNodes = new LinkedList<TreeNode>();
		Queue<TreeNode> rightNodes = new LinkedList<TreeNode>();
			 
		leftNodes.add(root.left);
		rightNodes.add(root.right);
			 
		while (!leftNodes.isEmpty() && !rightNodes.isEmpty()) {
			TreeNode leftNode = leftNodes.poll();
			TreeNode rightNode = rightNodes.poll();
				
			if (leftNode == null && rightNode == null) {
				continue;
			}else if (leftNode == null || rightNode == null ||leftNode.val != rightNode.val) {
				return false;
			}
				
			leftNodes.add(leftNode.left);
			leftNodes.add(leftNode.right);
			rightNodes.add(rightNode.right);
			rightNodes.add(rightNode.left);
				
		}
		return true;
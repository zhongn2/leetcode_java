//http://www.ritambhara.in/lowest-common-ancestor-in-binary-search-tree/
//找到最低祖先可能有3种情况
// 1. 要找的两个Node在左右子树，这样的话root就是公共祖先
// 2. 要找的两个node 在左子树，用recusion调用
// 同理， 在右边子树的话用recursion

public TreeNode LCA(TreeNode root, Node a, Node b){
	if(root == null || a == null || b == null) return null;
	if( root.val >= a.val && root.val <= b.val){ // make sure a < b
		return root;
	}
	if(root.val > a.val && root.val > b.val){
		return LCA( root.left, a, b);
	if(root.val < a.val && root.val < b.val){
		return LCA(root.right, a, b);
	}
}
// 主要思想就是递归  	
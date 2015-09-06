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
 两个关键点： 1. 为什么想到使用hashmap？
				使用hashmap，可以方便的获得root所在的index，然后迭代的时候就能够知道左树和右树的长度
			  2. 
 
 
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        int preLen = preorder.length;
        int inLen = inorder.length;
        // hashmap is used to record the root index
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < inLen; i++){
            indexMap.put(inorder[i], i);
        }
        
        return constructTree(preorder, 0, preLen-1, inorder, 0, inLen, indexMap);
    }
    public TreeNode constructTree(int[] preorder,int prelenL, int prelenR, int[] inorder, int inlenL, int inlenR, HashMap<Integer, Integer> indexMap){
        if(prelenR < prelenL || inlenR < inlenL){
            return null;
        }
        // find the root node in preorder 
        TreeNode root = new TreeNode(preorder[prelenL]);
        int index = indexMap.get(root.val); // root index
        // the index for preorder left bound should be the length of (index - inlenL) + prelenL
        root.left = constructTree(preorder, prelenL + 1, index - inlenL + prelenL , inorder, inlenL, index -1, indexMap);
        root.right = constructTree(preorder,index - inlenL + prelenL + 1 , prelenR, inorder, index + 1, inlenR, indexMap);
        
        return root;
  
    }
}
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
 对于当前的一个root来说：
  four situations:
   1. root val
   2. left + root
   3. right + root
   4. left + right + root
 
 
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxsum = new int[1];
        maxsum[0] = Integer.MIN_VALUE;
         localSum(root, maxsum);
         return maxsum[0];
    }
    public int localSum(TreeNode root, int[] max){
        if(root == null) return 0;
        // max is updated to be the max of left / right
        int leftsum = localSum(root.left, max);// 主体，访问左边节点，不是比较max和root.left，而是更新max
        int rightsum = localSum(root.right, max);
        int branch_sum = Math.max(root.val, Math.max(leftsum, rightsum) + root.val);
         max[0] = Math.max(max[0], Math.max(branch_sum, root.val + leftsum + rightsum)); // update
        
        return branch_sum;

        
    }
}
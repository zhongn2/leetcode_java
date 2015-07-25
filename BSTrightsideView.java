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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(result, root, 0);
        
        return result;
         
    }
    // 深度搜索，先右边，每次更新level的值， result的个数应该等于层数
    public  void dfs(List<Integer> result, TreeNode node, int level){
        if(node == null) return;
        if(level == result.size()){
            result.add(node.val);
        }
        
        dfs(result, node.right, level + 1); // 遍历下一层，先右边
        dfs(result, node.left, level + 1); // 后左边
        
    }
}

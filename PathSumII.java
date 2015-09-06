/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*  典型的树的深度搜索，如何添加path进入res？
		当我们发现一条路的时候，将path加入res,然后需要移除path当中的最后一个Node */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        
        pathDFS(root, sum, path, res);
        return  res;
    }
    private void pathDFS(TreeNode root, int sum, ArrayList<Integer> path,  List<List<Integer>> res){
        if(root == null) return;

        if(root.left == null && root.right == null){
            if(sum == root.val){
                path.add(root.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        
        path.add(root.val);
        pathDFS(root.left, sum - root.val, path, res);
        pathDFS(root.right, sum - root.val, path, res);
        path.remove(path.size()-1);
        
    }
}
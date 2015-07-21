/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Solution 1:
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> traversal = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode curr = root;
        if(root == null){
            return result;
        }
        traversal.push(root); // push root first
        while(!traversal.empty()){
            curr = traversal.peek();
            // 为了舒展开整个的tree
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null){
                    traversal.push(curr.left);
                }else if(curr.right != null){
                    traversal.push(curr.right);
                }
            //// 返回上一层看右节点
            }else if(curr.left == prev){
                if(curr.right != null){
                    traversal.push(curr.right);
                }
            }else{
                result.add(curr.val);
                traversal.pop();
            }
            prev = curr;
        }
        return result;
    }
}

//solution 2:

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<Integer>();
        if(root == null) return tree;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode top = stack.peek();
            
            if(top.left == null && top.right == null){
                stack.pop();
                tree.add(top.val);
            }
            // set the curr node left as null and jump out 
            if(top.left != null){
                stack.push(top.left);
                top.left = null;
                continue;
            }
            if(top.right != null){
                stack.push(top.right);
                top.right = null;
                continue;
            }
  
        }
        return tree;
        
    }
}
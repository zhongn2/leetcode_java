/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
            // Ϊ����չ��������tree
            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null){
                    traversal.push(curr.left);
                }else if(curr.right != null){
                    traversal.push(curr.right);
                }
            //// ������һ�㿴�ҽڵ�
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
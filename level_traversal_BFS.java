/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //每一层的数是用arraylist level来存储，一层访问之后，level必须重新初始化，否则里面的内容会继续保存。
 // Qsize 基本上就是相当于了每层的节点个数， 因为有新加入的，又有poll出去的
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
		// queue is abstract, has to be linkedlist
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
			// here level is temporary, it needs to be initialized every time
            ArrayList<Integer> level = new ArrayList<Integer>();
            int Qsize = q.size();
            for(int i = 0; i < Qsize; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                 if(node.right != null){
                    q.add(node.right);
                }
            }
            res.add(level);
        }
        return res;        
    }
}

/*
	FOLLOW-UP: 当我们需要bottom-up打印出tree的时候，则每次插入的位置都为0即可。
	res.add(0, level)
	C++当中，我们可以利用std::reverse(level.begin(), level.end());


*/
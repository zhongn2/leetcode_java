 // 中序是因为所有的node都按照递增的顺序，
//  然后通过找到2个错误的pointer并且记录pre，用来验证当前node是否合法
public class Solution {
    public TreeNode first, sec, pre;
	
    public void recoverTree(TreeNode root) {
        first = null;
        sec = null;
        pre = new TreeNode(Integer.MIN_VALUE);
        inorderTraversal(root);
        //swap the values of first and second 
        int tmp = first.val;
        first.val = sec.val;
        sec.val = tmp;
    }

    public void inorderTraversal(TreeNode currnode){
        if(currnode == null) return;
        // find left side
        inorderTraversal(currnode.left); //这里的迭代将currnode 移动到了最左边的节点，接着往上回溯
        // pre node is greater than current node
        if(pre.val > currnode.val){
            if(first == null){
				// the wrong nodes could be in the same subtree, we have to update sec here
                first = pre;
                sec = currnode;
            }else       // we found the first node already,sec would be current node
                sec = currnode;
        }
        pre = currnode;
        // apply to the right side
        inorderTraversal(currnode.right);
        
    }
}

//其实这道题是因为在tree里面，如果给定一个数组，告诉我们说两个元素放错了的话，
//也可以用同样的方法，找到两个错误点的index,最后swap两个点就OK了




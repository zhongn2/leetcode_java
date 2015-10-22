/*
 递归的思想
 T2是否是T1的子树，肯定我们知道的是递归调用subtree 函数，去试探T1的left和right子树
 还有一种可能就是T1和T2就是同一棵树
*/


// Time:  O(m * n)
// Space: O(h)

public class Solution {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
       if(T2 == null) return true;
       if(T1 == null) return false;
       return isSameTree(T1, T2) ||isSubtree(T1.left, T2)
                || isSubtree(T1.right, T2);
        
    }
    
    private boolean isSameTree(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return isSameTree(t1.right, t2.right) && isSameTree(t1.left, t2.left);
        
    }
}
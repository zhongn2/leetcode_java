/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//////////////////////////////////////////////////////////////////////////
//solution 1
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private TreeNode curr;
    
    public BSTIterator(TreeNode root) {
          while(!stack.isEmpty()){
            stack.pop();
        }
        curr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || curr != null;
    }

    /** @return the next smallest number */
    public int next() {
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        int value = curr.val;
        curr = curr.right;
        return value;
    }
}

//---------------------------------------------------------
//solution 2
public class BSTIterator {
    Stack<TreeNode>stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root != null){
            stack.push(root);
            root= root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
       TreeNode node = stack.pop();
       int value = node.val;
       if(node.right != null){
           node = node.right;
           while(node != null){
               stack.push(node);
               node = node.left;
           }
       }
       return value;
       
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
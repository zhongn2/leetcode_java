public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        int inlen = inorder.length;
        int postlen = postorder.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < inlen; i++){
            map.put(inorder[i], i);
        }
        return constructTree(inorder, 0, inlen -1, postorder, postlen -1, 0, map);        
    }
    
    public TreeNode constructTree(int[] inorder, int inlenL, int inlenR, int[] postorder, int postlenR, int postlenL,  HashMap<Integer, Integer> map){
        if(inlenL > inlenR || postlenL > postlenR){
            return null;
        }
        // from the right side
        TreeNode root = new TreeNode(postorder[postlenR]);
        int index = map.get(root.val);
        // construct right tree first, then left tree
        root.right = constructTree(inorder, index + 1, inlenR, postorder, postlenR - 1, postlenR -inlenR + index, map);
        root.left  = constructTree(inorder, inlenL, index - 1, postorder,postlenR -inlenR + index -1, postlenL, map);
        
        return root;
    }
}
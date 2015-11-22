/**
 还是容易想到DFS，serialize tree可以通过stringbuilder来实现
 deseralize 我们需要先将string进行处理，放入queue中，每次移
 出一个元素，进行判断是否为#，然后分别遍历左子树和右子树，最后
 汇成整个树。
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       StringBuilder sb = new StringBuilder();
       if(root == null){
           return "";
       }
       traversal(root, sb);
       return sb.toString();
    }
    
    private void traversal(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("# ");
        }else{
            sb.append(root.val + " ");
            traversal(root.left, sb);
            traversal(root.right, sb);
        }
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(" ")));
        return helper(queue);
    }
    private TreeNode helper(Queue<String> queue){
        String curr = queue.remove();
        if(curr.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(curr));
        root.left = helper(queue);
        root.right = helper(queue);
        
        return root;
            
    }
       
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
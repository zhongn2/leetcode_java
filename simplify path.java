// the use of stack
// LinkedList is used in Java 
// here we can use remove from last function to make sure 
// the order for the path


public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return null;
        }
        LinkedList<String> stack = new LinkedList<String>();
        String[] paths = path.split("/");
        
        for(String s : paths){
            if(s.length() == 0 || s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else{
                stack.push(s);
            }
        }
        
        if(stack.isEmpty()){
            stack.push("");
        }
        
        String res = "";
        
        while(!stack.isEmpty()){
            res += "/" + stack.removeLast();
        }
        
        return res;
    }
}
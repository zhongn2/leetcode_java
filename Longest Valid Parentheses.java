public class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0 || s == null) return 0;
        Stack<Integer> stack = new Stack<Integer>();// record the index for left parentheses
        int maxLen = 0;
        int last = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i); // push the index of "("
            }else{
                if(stack.isEmpty()){
                    last = i; // record the last "(" position
                }else{
                    stack.pop();
                    if(stack.isEmpty()){ // all the (  has been pushed out such as ())))
                        maxLen = Math.max(maxLen, i - last);
                    }else{
                        maxLen = Math.max(maxLen, i - stack.peek()); // update  such as (((())
						// since () is 2, when ( is pushed out
                    }
                }
                
            }
        }
        return maxLen;
        
    }
}
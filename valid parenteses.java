// almost the parentheses question are relate to stack
// how to push and pop the character into the stack
// hashmap is used to store the pair of info


public class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0 || s.length() == 1){
            return false;
        }
        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> match = new HashMap<Character, Character>();
        match.put('(', ')');
        match.put('[', ']');
        match.put('{', '}');
        
        for(Character c : brackets){
            if(match.containsKey(c)){
                stack.push(c);
            }else if(match.containsValue(c)){
                if(!stack.isEmpty() && match.get(stack.peek()) == c){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
       
    }
}
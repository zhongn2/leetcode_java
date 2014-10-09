public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            if(!words[i].equals("")){
           // equals applied in the object,every object has the equals method
           // it can be overrriden and it compares with the local memory address
                sb.append(words[i]).append(" ");
               
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1); 
        
    }
}
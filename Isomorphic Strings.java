/*
each key and value are unique. one key only has one value,and one value is for one key only
we use containsValue to check the value in O(n) time
if we want to check in constant time, we could have another hashmap - (value, key)


*/


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        
        HashMap<Character,Character> map = new HashMap();
       for(int i = 0; i <s.length(); i++){
           char m = s.charAt(i);
           char n = t.charAt(i);
           
           if(map.containsKey(m)){
               if(map.get(m) == n) continue;
               else 
               return false;
           }else if(map.containsValue(n)){
               return false;
           }else{
               map.put(m,n);
           }
    }
    return true;
}
}
}
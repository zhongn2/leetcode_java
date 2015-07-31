/*
	how to create the hashmap is the key
	Key: ordered string 
	values: anagrams
*/



public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if(strs.length == 0 || strs == null) return result;
        
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for(int i = 0; i < strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String orderedArr = new String(arr);
        
            ArrayList<String> anagram = new ArrayList<String>();
            
            if(map.containsKey(orderedArr)){
                map.get(orderedArr).add(strs[i]);
            }else{
                anagram.add(strs[i]);
                map.put(orderedArr,anagram);
            }
        }
        
        for(String key : map.keySet()){
            if(map.get(key).size() > 1){
                result.addAll(map.get(key));
            }
        }
        return result;
        
    }
}
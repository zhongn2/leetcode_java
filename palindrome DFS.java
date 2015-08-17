/*
	实质上还是subset的问题，只是每个subset多了一步去check是否是回文的操作
	pos: pos 是用来标记已经访问过的元素。比如 a b c ，已经用了a，i的作用就是循环a后面的所有元素，
	当a所能组成的结构都已经被枚举了后，从b开始继续。同时将a移除。


*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) return result;
        ArrayList<String> path = new ArrayList<String>();
        
        partitionHelper(result, path, s, 0);
        
        return result;
    }
    
    public void partitionHelper( List<List<String>> result, ArrayList<String> path, String s, int pos){
        if(pos == s.length()){
            result.add(new ArrayList<String>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++){
            String prefix = s.substring(pos, i+1);
            if(!isPalin(prefix)){
                continue;
            }
            path.add(prefix);
            partitionHelper(result, path, s, i+1);
            path.remove(path.size()-1);
            
        }
    }
    
    public boolean isPalin(String s){
        if(s == null || s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
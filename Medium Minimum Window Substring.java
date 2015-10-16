public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if(source == null || target == null) return "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : target.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        
        int minlen = source.length() + 1;
        int start = 0;
        int count = 0;
        int left = 0;
        // 从左到右找到符合的子串
		// 从左边开始，看left bound是否可以向右移动
		// hashmap 的value是可能为负数
        
        for(int i = 0; i < source.length(); i++){
            char c = source.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0){
                count++;
                }
                while(count == target.length()){
                    if(minlen > i - left + 1){
                        minlen = i - left + 1;
                        start = left;
                    }
                    
                    char m = source.charAt(left);
                    if(map.containsKey(m)){
                        map.put(m, map.get(m) + 1);
                        if(map.get(m) > 0 ){
                        count--;
                        }
                    }
                    left++;
                }
            }
        }
        if(minlen > source.length()) return "";
        return source.substring(start, start + minlen);
        
    }
}

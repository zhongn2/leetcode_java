// use a hashset to storethe unique sequence
// use the leftbound to watch 


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int leftbound = 0, max = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
			// 这种情况就是发现了其他的字符串更多的时候
			// 移除了目前存入的所有字符，同时记录下走到了哪里
                while(leftbound < i && s.charAt(leftbound) != s.charAt(i)){
                    set.remove(s.charAt(leftbound));
                    leftbound++; // 移除一个，向前走一步
                }
				// 删除完之后也需要走一步
                leftbound++;
                
            }else{
                set.add(s.charAt(i));
                max = Math.max(max, i - leftbound + 1);
            }
        }
        return max;
    }
}

// method 2
// use two pointers to represent the element can be choose or not
// which is simple to understand

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.size() == 0) return 0;
        if(s.size() == 1) return 1;
        int i = 0, j = 0, maxl = 0;
        map<char,bool>m;
        while(i < s.size() && j < s.size()){
            if(m[s[j]] == false){
                m[s[j]] = true;
                maxl = max(maxl, j - i + 1);
                j++;
            }
            if(m[s[j]] == true){
                m[s[i]] = false;
                maxl = max(maxl, j - i);
                i++;
            }
        }
        return maxl;
    }
};
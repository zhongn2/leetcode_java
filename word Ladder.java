// every time there is only one character could be changed
// so emunation could be a good way to reduce the time complexcity
// if we don't know how many changes it could be, we have search for each word in dict
// http://rangerway.com/way/leetcode-word-ladder-ii/
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(dict == null | start == null || end == null){
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        int len = 1;
        queue.add(start);
        dict.remove(start);
        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i = 0; i < s; i++){
                String current = queue.poll();
				// emunate the different set of word and compare it with the dict
                for(char c = 'a'; c < 'z'; c++){
                    for(int j = 0; j < current.length(); j++){
                        if(c == current.charAt(j)){
                            continue;
                        }
                        String tmp = replace(current, j, c);
						// we compare the tmp with end and stop when we find it coz it is a optimal solution in BFS
                        if(tmp.equals(end)){
                            return len + 1;
                        }
                        if(dict.contains(tmp)){
                            queue.add(tmp);
                            dict.remove(tmp);
                        }
                    }
                }
            }
			// when we have done the search for one level, move to the next level
            len++;
          }
        return 0;
        }
        
        private String replace(String s, int index, char c){
            char[] arr = s.toCharArray();
            arr[index] = c;
            return new String(arr);
        }
        
    }

// 这道题首先想到DP， dp的话
// dp[i] 表示operator为i个时，解法的总数
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
	       if (input.length() == 0 || input == null) {
	    	   return  res;
	       }
	       for (int i = 0; i < input.length(); i++) {
	    	   char c = input.charAt(i);
	    	   if (Character.isDigit(c)) {
	    		   continue;
	    	   }
	    	   List<Integer> left = diffWaysToCompute(input.substring(0, i));
	    	   List<Integer> right = diffWaysToCompute(input.substring(i+1));
	    	 for(int a : left){
	    		 for(int b : right){
	    			 switch (c) {
					case '+': res.add(a + b); break;
					case '-': res.add(a - b); break;
					case '*': res.add(a * b); break;
					}
	    		 }
	    	 }
	       }
	       if (res.size() == 0) {
				res.add(Integer.parseInt(input));
		       }
	  	 return res;
        
    }
}
}
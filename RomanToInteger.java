/*
	罗马数字变成整形
	如果后面的数字比前面的大，则视为减
	http://blog.csdn.net/wzy_1988/article/details/17057929
*/


public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int i, pre, curr, sum;
        sum = RomanTable(s.charAt(0));
        
        for(i = 1; i < s.length(); i++){
            pre = RomanTable(s.charAt(i-1));
            curr = RomanTable(s.charAt(i));
            
            if(curr <= pre){
                sum += curr;
            }else{
                sum = sum + curr - 2*pre;
            }
        }
        
        return sum;
    }
	//这里的逻辑是从前往后，当前的数是+还是- 取决去后面的数
	// 在for循环里，，
	//判断后面一位的时候，都是加，所以当i已经到了尾巴，直接加上，为了不越界
	/*
	 public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        
        char[] arr = s.toCharArray();
        int sum = 0, curr;
        
        for(int i = 0; i < arr.length; i++){
            curr = RomanTable(arr[i]);
            
            if(i == arr.length - 1  || RomanTable(arr[i + 1])<= curr ){
                sum += curr;
            }else{
                sum -= curr;
            }
        }
        return sum;
       
    }
	
	*/
    
    public int RomanTable(char c){
        int num = 0;
    
        switch(c){
            case 'I': num = 1; break;
            case 'V': num = 5; break;
            case 'X': num = 10; break;
            case 'L': num = 50; break;
            case 'C': num = 100; break;
            case 'D': num = 500; break;
            case 'M': num = 1000; break;
        }
        
        return num;
    }
}


// solution 2
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romans = new HashMap<Character, Integer>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        char[] cs = s.toCharArray();
        int num = 0;
        int val;
        for (int i = 0; i < cs.length; i++) {
            val = romans.get(cs[i]);
            if (i == cs.length - 1 || romans.get(cs[i + 1]) <= val) {
                num += val;
            } else {
                num -= val;
            }
        }
        return num;
    }
}
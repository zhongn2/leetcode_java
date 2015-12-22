		if(s == null) return 0;
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		int sign = 1;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// check it is a long number such as 1234 + 23 + (1 - 1)
			if(Character.isDigit(c)){
				int curr = c - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
					curr = curr * 10 + s.charAt(++i) -'0';
				}
				result += sign * curr;
			}else if (c == '-') {
				sign = -1;
			}else if (c == '+') {
				sign = 1;
			}else if (c == '(') {
				// store the result at the left size of bracket
				// resigned result and sign
				stack.push(result);
				result = 0;
				stack.push(sign);
				sign = 1;
			}else if (c == ')') {
				// we store the inner result and sign 
				// sign is before result, pop them in an order
				int tmpsign = stack.pop();
				result = result * tmpsign + stack.pop();
			}
		}
		return result;
		
//solution 2:
public static int calculatorI(String s){
		if (s == null || s.length() == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>(); // used to store the signs, when meets with (, the sign should 
		int result = 0, sign = 1, number = 0;
		stack.push(sign);
		
		for(char c : s.toCharArray()){
			if (Character.isDigit(c)) {
				number = number * 10 + c - '0';
			}else if (c == '+' || c == '-') {
				result += sign * number * stack.peek();
				number = 0;
				sign = (c == '+' ? 1 : -1);
			}else if (c == '(') {
				stack.push(sign * stack.peek());
				sign = 1;
			}else if (c == ')') {
				result += stack.pop() * sign * number;
				number = 0;
				sign = 1;
			}
		}
		if (number != 0) {
			result += number * sign;
		}
		return result;
	}
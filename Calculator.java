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
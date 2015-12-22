 public static String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0){
        	return "0";
        }
        StringBuilder result = new StringBuilder();
        result.append((numerator > 0) ^(denominator > 0) ? "-" :"");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        result.append(num/den);
        num %= den;
        if (num == 0) {
			return result.toString();
		}
        //fractional part
		//这部分是用map 记录重复的数字，和它第一次出现的index
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, result.length());
        while(num != 0){
        	num *= 10;
        	result.append(num/den);
        	num %= den;
        	if (map.containsKey(num)) {
        		int index = map.get(num);
        		result.insert(index, "(");
        		result.append(")");
        		break;
				
			}else {
				map.put(num, result.length());
			}
        }
        return result.toString();
        
    }
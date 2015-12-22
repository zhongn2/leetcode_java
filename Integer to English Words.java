 private static String[] under20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
    		"Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
    		"Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", 
    		"Sixty", "Seventy", "Eighty", "Ninety"};
    
    private static String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public static String numberToWords(int num) {
    	if (num == 0) {
			return "zero";
		}
    	StringBuilder sb = new StringBuilder();
    	int curr, index = 0;
    	while(num != 0){
    		curr = num % 1000;// 123,230 curr = 230
    		if (curr != 0) {
				sb.insert(0, " ").insert(0, thousands[index]).insert(0, subhelper(curr));
			}
    		num /= 1000;
    		index++;
    	}
    	return sb.toString().trim();
    }
	// subhelper 的作用就是读出3 digits，然后迭代加入sb
	private static StringBuilder subhelper(int curr) {
		StringBuilder sb = new StringBuilder();
		if (curr == 0) {
			return sb;
		}else if (curr < 20) {
			sb.append(under20[curr]).append(" ");
		}else if (curr < 100) {
			sb.append(tens[curr / 10]).append(" ").append(subhelper(curr % 10));
		}else{
			sb.append(under20[curr/100]).append(" hundrand ").append(subhelper(curr % 100));
		}
		return sb;
	}
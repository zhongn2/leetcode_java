public boolean verifyPreorder(int[] preorder) {
    int low = Integer.MIN_VALUE, i = -1;
    for (int p : preorder) {
        if (p < low)
            return false;
        while (i >= 0 && p > preorder[i])
            low = preorder[i--];
        preorder[++i] = p;
    }
    return true;
}

 // method 1:
 //verify an array is a pre-order of BST O(n) space, method 1 is O(1) space
 // keep track of bound, the number in the right subtree should greater than bound itself
	    public static boolean preorder(int[] num) {
	    	if(num == null) return true;
	    	int bound = Integer.MIN_VALUE;
	    	Stack<Integer> stack = new Stack<>();
	    	
	    	for (int i : num) {
				if(i < bound){
					return false;
				}
				while (!stack.isEmpty() && i > stack.peek()) {
					bound = stack.pop();
				}
				stack.push(i);
			}
	    	
	    	return true;
		}
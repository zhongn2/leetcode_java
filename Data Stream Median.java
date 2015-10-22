public static int[] median(int[] nums) {  
        int len = nums.length;
        int res[] = new int[len];
        if(nums == null || len == 0) return res;
        
        PriorityQueue<Integer>min_heap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(10,new Comparator<Integer>() {

			@Override
			public int compare(Integer in1, Integer in2) {
				// TODO Auto-generated method stub
				return in2 - in1;
			}
		});
        
        max_heap.add(nums[0]);
        res[0] = nums[0];
        
        for(int i = 1; i < len; i++){
        	int top = max_heap.peek();
        	if (nums[i] >= top) {
				min_heap.offer(nums[i]);
			}else{
				max_heap.offer(nums[i]);
			}
        	
        	if(max_heap.size() > min_heap.size() + 1){
        		min_heap.offer(max_heap.poll());
        	}else if (max_heap.size() < min_heap.size()) {
				max_heap.offer(min_heap.poll());
			}
        	res[i] = max_heap.peek();
				
        }
        
        return res;
        
	}
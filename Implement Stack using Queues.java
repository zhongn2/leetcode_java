/*
这道题的push的key在于：
我们需要改变queue中的顺序。
比如： 2 1 ---> 1 2
介入 3： 3 1 2 --> 1 2 3 

*/


class MyStack {
    // Push element x onto stack.
    Queue<Integer> Q1 = new LinkedList<>();
 
    public void push(int x) {
        Q1.add(x);
		//需要变化的是加入之前的元素的个数
        for(int i = 0; i < Q1.size()-1; ++i){
            Q1.add(Q1.peek());
            Q1.poll();
        }
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        Q1.poll();
    }

    // Get the top element.
    public int top() {
        return Q1.peek();
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return Q1.isEmpty();
    }
}
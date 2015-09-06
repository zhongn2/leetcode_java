import java.util.Stack;

//Min_stack
// using two stacks to implement a minstack
// the first stack is to store numbers, the other one is to store the min number from 1st stack

public class minstack{
	private Stack<Integer> stack1; 
	private Stack<Integer> min_stack; 
	// copy constructor
	public minstack(){
		stack1 = new Stack<Integer>();
		min_stack = new Stack<Integer>();
	}
	
	public void push(int number){
		stack1.push(number);
		if(min_stack.empty()){
			min_stack.push(number);
		}else{
			if(min_stack.peek() >= number){
				min_stack.push(number);
			}
		}
	}
	public int pop(){
		if(stack1.peek() == min_stack.peek()){
			min_stack.pop();
		}
		return stack1.pop();
	}
	public int min(){
		return min_stack.peek();
	}
	public static void main(String[] args){
		minstack minstack = new minstack();
		minstack.push(2);
		minstack.push(4);
		minstack.push(10);
		minstack.push(3);
		minstack.pop();
		System.out.println(minstack.min());
	}
}
// solution 2

private Stack<Integer> stack = new Stack<Integer>();
private Stack<Integer> minStack = new Stack<Integer>();


public void push(int x) {
    stack.push(x);
    if(minStack.isEmpty() || x <= minStack.peek()){
        minStack.push(x);
    }
}

public void pop() {
    if(stack.isEmpty()){
        return;
    }
    int x = stack.peek();
    if(!minStack.isEmpty() && x == minStack.peek()){
        minStack.pop();
    }
    stack.pop();
}

public int top() {
    return stack.peek();
}

public int getMin() {
    if(minStack.isEmpty()){
        return 0;
    }
    return minStack.peek();
}
// solution 3, only use one stack
public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop=stack.pop();

        if (pop<0)  min=min-pop;//If negative, increase the min value

    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}

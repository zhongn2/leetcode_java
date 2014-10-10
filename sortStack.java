// sort a stack in ascending order
// we already have a stack that is in ascending order such as 9 7 6 3
// and another stack with random number such as 5 3 10
public Stack<Integer> sort(Stack<Integer> stack){
	Stack<Integer> result = Stack<Integer>(); // r should be in ascending order
	while(!stack.isEmpty()){
		int num = stack.pop();
		while(result.peek() > num && !result.isEmpty()){
			stack.push(result.pop());
		}
		result.push(num);
	}
	return result;
}

public abstract class Animal{
	private int order;
	protected String name;
	
	public Animal(String n){
		name = n;
	}
	public void setOrder(int n){
		order = n;
	}
	public void getOrder(){
		return order;
	}
	public boolean isOlder(Animal a){
		return this.order > a.getOrder();
	}
}
public class Dog extends Animal{
public Dog(String n){
	super(n);
	}
}

public class Cat extends Animal{
public Cat(String n){
	super(n);
	}
}

public class animalQueue{
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>():
	private int order = 0;
	public void dequeue(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog) dogs.addLast((Dog) a);
		if(a instanceof Cat) cats.addLast((Cat) a);
	}
	public Animal dequeueAny{
	// check dogs and cats queue whether they have elements
	if(dogs.size() == 0){
		return dequeueCat();
	}
	if(cats.size() == 0){
		return dequeueDog():
	}
	Animal d = dogs.peek():
	Animal c = cats.peek();
	if(d.isOlder(c) == true){
		return dequeueDog();
	}else{
		return dequeueCat();
	}
	public Dog dequeueDog(){
		return dogs.poll();
	}
	public Cat dequeueCat(){
		return cats.poll();
	}
}
}
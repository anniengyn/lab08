
public class StackAsList<T> implements Stack<T> {

	private T[] stackArray = null;
	private int top = -1;
	private int maxSize;
	
	@SuppressWarnings("unchecked")
	
	public StackAsList(int cap) {
		maxSize = cap;
		stackArray = (T[]) new Object[cap];
	}


	public static void main(String[] args) throws StackUnderflow, StackOverflow {
		
		try {
		Stack<Integer> stack = new StackAsList<Integer>(5);
	
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
 
		System.out.println(stack);
 
		stack.pop();
		System.out.println(stack);
 
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		}
		
		
		
		catch ( StackUnderflow e )
		{
			System.out.println("Error detected: " + e.getMessage() );
			System.exit(1);
		}
		
		catch ( StackOverflow e )
		{
			System.out.println("Error detected: " + e.getMessage() );
			System.exit(1);
		}
		

	}
	
	// Returns a String that outputs the contents of the Stack 
	
	public String toString() {
		if (isEmpty()) {
			return null;
		}
 
		StringBuilder sb = new StringBuilder();
		for(int i=0; i <= top; i++){
			sb.append(stackArray[i] + ", ");
		}
 
		sb.setLength(sb.length()-2);
		return sb.toString();	
	}

	// Checks if the Stack is empty
	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}
	
	// Checks if the Stack is full
	@Override
	public boolean isFull() {
		if (top == maxSize - 1) {
			return true;
		}
		return false;
	}

	// adds or "pushes" a new element to the stack
	@Override
	public void push(T t) throws StackOverflow {
		
		if (isFull()) {
			throw new StackOverflow("Stack overflow");
		}
			
		
		stackArray[++top] = t;
		

	}

	// removes or "pops" the last element added from the stack 
	@Override
	public T pop() throws StackUnderflow {
		
		if (isEmpty()) {
			throw new StackUnderflow("Stack underflow");
		}
		
		
		T result = stackArray[top];
		stackArray[top] = null;  //prevent memory leaking
		top--;
 
		return result;
	}



}

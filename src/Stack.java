
public interface Stack<T> {
	public void push(T Object) throws StackOverflow;
	public T pop() throws StackUnderflow;
	public boolean isEmpty();
	public boolean isFull();
	public String toString();
	public char peek();
}

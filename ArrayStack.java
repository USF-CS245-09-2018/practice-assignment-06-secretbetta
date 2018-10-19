
public class ArrayStack implements Stack {
	private Object arr[];
	private int head;
	
	/**
	 * Default stack initializer
	 */
	public ArrayStack() {
		head = 0;
		arr = new Object[10];
	}
	
	/**
	 * Stack initializer with size
	 * @param size Size of array
	 */
	public ArrayStack(int size) {
		head = 0;
		arr = new Object[size];
	}
	
	
	@Override
	public void push(Object item) {
		if (head >= arr.length) {
			grow();
			arr[head++] = item;
		} else {
			arr[head++] = item;
		}
	}

	/**
	 * Gets rid of top of the stack
	 * @return Returns top of stack, null if empty
	 */
	@Override
	public Object pop() {
		if (empty()) {
			return null;
		} else {
			return arr[--head];
		}
	}
	
	/**
	 * Looks at top of array
	 */
	@Override
	public Object peek() {
		return arr[head];
	}
	
	/**
	 * Checks if Stack is empty
	 * @return true if empty
	 */
	@Override
	public boolean empty() {
		if (head == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Increases stack size
	 */
	public void grow() {
		Object[] temp = new Object[arr.length * 2];
		for (int x = 0; x < head; x++) {
			temp[x] = arr[x];
		}
		arr = temp;
	}
}

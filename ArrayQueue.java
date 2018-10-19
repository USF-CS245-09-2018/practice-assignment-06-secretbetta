
public class ArrayQueue implements Queue {
	private Object[] arr;
	private int head;
	private int tail;
	
	/**
	 * Initializes Queue
	 */
	public ArrayQueue() {
		arr = new Object[10];
		head = 0;
		tail = 0;
	}
	
	/**
	 * "dequeue"s array.
	 * @return Returns head of array, null if empty
	 */
	@Override
	public Object dequeue() {
		if (empty()) {
			return null;
		} else {
			return arr[head++];
		}
	}
	
	/**
	 * "queue"s item into array, grows array if array is full
	 */
	@Override
	public void enqueue(Object item) {
		if  ((tail)%(arr.length) < head) {
			arr[tail%(arr.length)] = item;
			tail++;
		} else if (tail >= arr.length) {
			grow();
			arr[tail++] = item;
		} else {
			arr[tail++] = item;
		}
	}
	
	/**
	 * Checks if array is empty
	 * @return true if empty;
	 */
	@Override
	public boolean empty() {
		if (head == tail) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Doubles the size of the array
	 */
	private void grow() {
		Object[] temp = new Object[arr.length * 2];
		for (int x = 0; x < arr.length; x++) {
			temp[x] = arr[(x + head)%(arr.length)];
		}
		head = 0;
		tail = arr.length;
		arr = temp;
	}
}

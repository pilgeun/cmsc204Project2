/**
 * 
 * @author PHILIP SONG
 * */

import java.util.ArrayList;

public class MyQueue <T> implements QueueInterface<T> {

	private T[] queue;
	private int frontIndex, backIndex, maxIndex;
	private static final int MAX_INDEX = 50;
	
	public MyQueue() {
		this(MAX_INDEX);
	}
	
	@SuppressWarnings("unchecked")
	public MyQueue(int maxQueue) {
		
		T[] tempQueue = (T[]) new Object[maxQueue + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = 0;
		maxIndex = maxQueue;
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return queue[frontIndex] == null;
	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		boolean full = true;
		
		for (int i = 0; i < maxIndex; i++)
		{
			if (queue[i] == null)
			{
				full = false;
				break;
			}
		}
		
		return full;
	}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return Math.abs(backIndex - frontIndex);
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T front = null;
		
		if(!isEmpty())
		{
			front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
		}
		
		else
			throw new QueueUnderflowException();
		
		return front;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param object the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean enqueue(Object object) throws QueueOverflowException {
		boolean added = false;		
		
		if(!isFull())
		{
			queue[backIndex] = (T) object;
			backIndex = (backIndex + 1) % queue.length; 
			added = true;
		}
		
		else
			throw new QueueOverflowException();
		
		return added;
	}

	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String line = "";
		
		for(int i = frontIndex; i < backIndex; i++)
		{
			if (i < queue.length)
				line += queue[i];
			else
				i = (i+1)%queue.length;
		}
			
		
		return line;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String line = "";
		
		for(int i = frontIndex; i < backIndex; i++)
		{
			if (i < queue.length)
			{
				line += queue[i];
				if (i < backIndex-1)
					line += delimiter;
			}
			else
				i = (i+1)%queue.length;
		}
		
		return line;
	}


	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	  */
	@Override
	public void fill(ArrayList list) {
		ArrayList tempList = list;
		
		for (int i = 0; i < tempList.size(); i++) {
			try {
				enqueue(tempList.get(i));
			} catch (QueueOverflowException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}

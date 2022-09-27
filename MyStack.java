/**
 * 
 * @author PHILIP SONG
 * */

import java.util.ArrayList;

public class MyStack <T> implements StackInterface<T> {

	private T[] stack;
	private int topIndex;	// index of item on top of stack
	private static final int MAX_INDEX = 50;
	
	public MyStack() {
		this(MAX_INDEX);
	}
	
	@SuppressWarnings("unchecked")
	public MyStack(int maxStack) {
		T[] tempStack = (T[]) new Object[maxStack];
		stack = tempStack;
		
		topIndex = -1;
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return stack[0] == null;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		
		if (topIndex == stack.length-1)
			return true;
		
		return false;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		T tossed = null;
		
		if (!isEmpty())
		{
			tossed = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
		}
		
		else
			throw new StackUnderflowException();
			
		return tossed;
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		T item = null;
		
		if (!isEmpty())
			item = stack[topIndex];
		else 
			throw new StackUnderflowException();
		
		return item;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(Object e) throws StackOverflowException {
		boolean added = false;
		
		if (!isFull()) {
			topIndex++;
			stack[topIndex] = (T) e;
			added = true;
		}
		
		else if (isFull())
			throw new StackOverflowException();
		
		return added;
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		return topIndex+1;
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String line = "";
		
		for(int i = 0; i <= topIndex; i++)
			line += stack[i];
		
		return line;
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String line = "";
		
		for(int i = 0; i <= topIndex; i++)
		{
			
				line += stack[i];
				if (i < topIndex)
					line += delimiter;
		}
		
		return line;
	}

	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList list) {
		ArrayList tempList = list;
		
		for (int i = 0; i < tempList.size(); i++) {
			try {
				push(tempList.get(i));
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		}
	}

}

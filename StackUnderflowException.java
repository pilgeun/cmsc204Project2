/**
 * StackUnderflowException – occurs when a top or pop method is called on an empty stack.
 * @author Philip Song
*/

public class StackUnderflowException extends Exception {
	/**
	 * Constructor.
	 */
	public StackUnderflowException() {
		this("Stack is empty");
	}
	
	/**
	 * @param message
	 */
	public StackUnderflowException(String message) {
		super(message);
	}
}

/**
 * StackOverflowException– occurs when a push method is called on a full stack.
 * @author PHILIP SONG
 * */

public class StackOverflowException extends Exception {
	/**
	 * Constructor.
	 */
	public StackOverflowException() {
		this("Stack is full");
	}
	
	/**
	 * @param message
	 */
	public StackOverflowException(String message) {
		super(message);
	}
}

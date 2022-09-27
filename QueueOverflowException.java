/**
 * QueueOverflowException – occurs when a enqueue method is called on a full queue.
 * @author PHILIP SONG
 * */

public class QueueOverflowException extends Exception {
	/**
	 * Constructor.
	 */
	public QueueOverflowException() {
		this("Queue is full");
	}
	
	/**
	 * @param message
	 */
	public QueueOverflowException(String message) {
		super(message);
	}

}

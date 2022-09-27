/**
 * QueueUnderflowException  – occurs when a  dequeue method is called on an empty queue.
 * @author PHILIP SONG
 * */

public class QueueUnderflowException extends Exception {
	/**
	 * Constructor.
	 */
	public QueueUnderflowException() {
		this("Queue is empty");
	}
	
	/**
	 * @param message
	 */
	public QueueUnderflowException(String message) {
		super(message);
	}

}

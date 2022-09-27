
/**
 * InvalidNotationFormatException – occurs when a Notation format is incorrect
 * @author PHILIP SONG
 */

public class InvalidNotationFormatException extends Exception {
	/**
	 * Constructor.
	 */
	public InvalidNotationFormatException() {
		this("Notation format is incorrect");
	}
	
	public InvalidNotationFormatException(String message) {
		super(message);
	}

}

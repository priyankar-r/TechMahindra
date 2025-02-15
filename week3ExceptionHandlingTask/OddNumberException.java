package week3ExceptionHandlingTask;

public class OddNumberException extends Exception {
	public OddNumberException(String message) {
        super(message); // Call the constructor of the parent class (Exception)
    }
}
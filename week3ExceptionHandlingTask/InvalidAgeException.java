package week3ExceptionHandlingTask;

public class InvalidAgeException extends Exception{
	public InvalidAgeException(String message) {
        super(message); // Call the constructor of the parent class (Exception)
    }
}
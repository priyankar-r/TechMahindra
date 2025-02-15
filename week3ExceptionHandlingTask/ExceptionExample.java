package week3ExceptionHandlingTask;

public class ExceptionExample {
	public static void main(String[] args) {
        try {
        	// invalid age
            int age = -5; 
            validateAge(age);
            System.out.println("age is valid: " + age);

        } catch (InvalidAgeException e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            // this block will always execute
            System.out.println("finally block executed.");
        }
    }

    // check to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            // throw a custom exception if age is invalid
            throw new InvalidAgeException("age cannot be negative.");
        }
    }
}

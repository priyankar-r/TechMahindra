package week1task;
import java.util.Scanner;
public class FactorialZeroCalculation {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// get factorial number from the user as input
		int factorial_num = sc.nextInt();
		// close the scanner class to stop data leakage
		sc.close();
		// initialize as power variable as zero
		int power = 0;
		// check if the factorial number is greater than 5
		if (factorial_num >= 5) {
			for (int i = 0; i < 1000000; i++) {
				// check the factorial number if it is greater than any number power of 5
				if (factorial_num < (int) Math.pow(5, i)) {
					// store the i value inside power variable
					power = i;
					break;
				}
			}
		} else {
			System.out.println("Trailing Zeros is 0");
		} // print the output by calling the calculateZeros()
		System.out.println("Trailing Zeros is " + calculateZeros(factorial_num, power));
	}

	// method to calculate trailing zeros
	public static int calculateZeros(int factorial_num, int power) {
		
		int trialZeroCount = 0;
		
		for (int j = 1; j < power; j++) {
			trialZeroCount = trialZeroCount + (factorial_num / ((int) Math.pow(5, j)));
		}
		// return the trailing zeros calculated
		return trialZeroCount;
	}
}
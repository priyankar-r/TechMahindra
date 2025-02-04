package week1task;

import java.util.Scanner;

public class DivisionNew {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numerator = sc.nextInt();
		int denominator = sc.nextInt();
		sc.close();
		
		//check if the denominator value is not 0
		if (denominator == 0) {
            System.out.println("Error: Division by zero is undefined.");
            return;
        }
		
		int quotient = 0;
		while (numerator - denominator >= 0) {
			quotient++;
			numerator = numerator - denominator;
		}
		
		System.out.println("Divison of numbers: " + quotient);
		System.out.println("Remainder: " + numerator);
	}
}

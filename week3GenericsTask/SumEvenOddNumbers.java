package week3GenericsTask;
import java.util.*;
public class SumEvenOddNumbers {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // create a list to store numbers
        List<Double> num = new ArrayList<>();
        System.out.print("enter the no of elements: ");
        int n = sc.nextInt();
        System.out.println("enter the elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("element " + (i + 1) + ": ");
            num.add(sc.nextDouble());
        }

       sumEvenOdd(num);

        sc.close();
    }

    // generic method to calculate the sum of even and odd numbers
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
       int evenSum = 0;
       int oddSum = 0;

        for (T number : numbers) {
            int value = number.intValue();
            if (value % 2 == 0) {
                evenSum += value;
            } else {
                oddSum += value;
            }
        }
        System.out.println("sum of even numbers: " + evenSum);
        System.out.println("sum of odd numbers: " + oddSum);
    }
}

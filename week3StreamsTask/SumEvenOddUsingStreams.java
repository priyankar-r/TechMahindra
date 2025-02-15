package week3StreamsTask;

import java.util.Arrays;
import java.util.List;

public class SumEvenOddUsingStreams {
	public static void main(String[] args) {
        // create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // calculate the sum of even numbers
        int sumEven = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        // calculate the sum of odd numbers
        int sumOdd = numbers.stream()
                .filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        // print the results
        System.out.println("Sum of even numbers: " + sumEven);
        System.out.println("Sum of odd numbers: " + sumOdd);
    }
}

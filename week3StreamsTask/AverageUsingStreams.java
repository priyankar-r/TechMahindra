package week3StreamsTask;

import java.util.Arrays;
import java.util.List;

public class AverageUsingStreams {
	public static void main(String[] args) {
		// create a list of integers
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
		// calculate the average using streams
		double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
		// print the average
		System.out.println("average: " + average);
	}
}

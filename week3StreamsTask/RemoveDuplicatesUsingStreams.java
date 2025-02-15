package week3StreamsTask;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesUsingStreams {
	public static void main(String[] args) {
        // create a list with duplicate elements
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 7, 1);
        // remove duplicates using streams
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        // print the results
        System.out.println("original List: " + numbers);
        System.out.println("list without duplicates: " + uniqueNumbers);
    }
}
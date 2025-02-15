package week3StreamsTask;

import java.util.Arrays;
import java.util.List;

public class CountStringsStartingWithLetter {
	public static void main(String[] args) {
        // create a list of strings
        List<String> strings = Arrays.asList("Apple", "Banana", "Apricot", "Mango", "Avocado", "Blueberry");
        // specify the letter to check
        char startingLetter = 'A';
        // count the number of strings that start with the specified letter
        long count = strings.stream().filter(s -> !s.isEmpty() && s.charAt(0) == Character.toUpperCase(startingLetter)).count();
        // print the result
        System.out.println("number of strings starting with '" + startingLetter + "': " + count);
    }
}

package week3StreamsTask;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringCaseUsingStreams {
	public static void main(String[] args) {
        // create a list of strings
        List<String> strings = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        // convert to uppercase
        List<String> uppercaseStrings = strings.stream().map(String::toUpperCase).collect(Collectors.toList()); 
        // convert to lowercase
        List<String> lowercaseStrings = strings.stream().map(String::toLowerCase).collect(Collectors.toList());

        // print the results
        System.out.println("uppercase list: " + uppercaseStrings);
        System.out.println("lowercase list: " + lowercaseStrings);
    }
}

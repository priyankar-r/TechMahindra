package week3StreamsTask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortStringsUsingStreams {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // create a list to store the strings
        List<String> strings = new ArrayList<>();
        System.out.print("enter the number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("enter the strings:");
        for (int i = 0; i < n; i++) {
            System.out.print("string " + (i + 1) + ": ");
            strings.add(sc.nextLine());
        }
        // sort in ascending order
        List<String> ascendingOrder = strings.stream().sorted().collect(Collectors.toList());
        // sort in descending order
        List<String> descendingOrder = strings.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); 
        System.out.println("sorted in Ascending Order: " + ascendingOrder);
        System.out.println("sorted in Descending Order: " + descendingOrder);
        // close the scanner class
        sc.close();
	}
}
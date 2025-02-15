package week3GenericsTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FindElementIndex {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // create a list to store elements
        List<String> list = new ArrayList<>();
        System.out.print("enter the number of elements in the list: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("enter the elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("element " + (i + 1) + ": ");
            list.add(sc.nextLine());
        }
        System.out.print("enter the target element: ");
        String target = sc.nextLine();
        int index = findFirstOccurrence(list, target);

        // print the result
        if (index != -1) {
            System.out.println("the first occurrence of '" + target + "' is at index: " + index);
        } else {
            System.out.println("the element " + target + " was not found in the list.");
        }

        sc.close();
    }

    // generic method to find the index of the first occurrence of a target element
    public static <T> int findFirstOccurrence(List<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
            	// return the index
                return i;
            }
        }
     // if the target element is not found
        return -1; 
    }
}

package week3GenericsTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseList {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // create a list to store elements
        List<String> list = new ArrayList<>();
        System.out.print("enter the no of elements in the list: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        System.out.println("enter the elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("element " + (i + 1) + ": ");
            list.add(sc.nextLine());
        }
        List<String> reversedList = reverseList(list);

        // print the reversed list
        System.out.println("reversed list:");
        for (String element : reversedList) {
            System.out.print(element + " ");
        }

        sc.close();
    }

    // generic method to reverse a list
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }
}

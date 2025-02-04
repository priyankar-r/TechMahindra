package utility;
import utility.Utility;
import java.util.Scanner;
public class UtilityTester {
	public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	int len = Utility.findLength(num);
	System.out.println("The length of the integer " + num + " is " + len);
	sc.close();
	}
}

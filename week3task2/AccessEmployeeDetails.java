package week3task2;
import java.util.*;
public class AccessEmployeeDetails {public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);

    // create an employeeDetails object
    employeeDetails emp = new employeeDetails();

    // get employee details from the user
    System.out.print("enter employee ID: ");
    int empId = sc.nextInt();
    sc.nextLine();

    System.out.print("enter employee name: ");
    String empName = sc.nextLine();

    System.out.print("enter annual salary: ");
    double sal = sc.nextDouble();

    System.out.print("enter years worked: ");
    int yearsWorked = sc.nextInt();

    // set employee details
    emp.setEmployeeDetails(empId, empName, sal, yearsWorked);

    // print employee details
    System.out.println("\nEmployee Details:");
    emp.getEmployeeDetails();

    // check loan eligibility
    System.out.println("\nLoan Eligibility:");
    emp.getLoanEligibility();

    // close the scanner class
    sc.close();
}
}

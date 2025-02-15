package week3task2;

public class employeeDetails {
	private int empId;
	private String empName;
	private double sal;
	private int yearsWorked;

	// set employee details
	public void setEmployeeDetails(int empId, String empName, double sal, int yearsWorked) {
		this.empId = empId;
		this.empName = empName;
		this.sal = sal;
		this.yearsWorked = yearsWorked;
	}

	// get employee details
	public void getEmployeeDetails() {
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + empName);
		System.out.println("Annual Salary: " + sal);
		System.out.println("Years Worked: " + yearsWorked);
	}

	// check loan eligibility
	public void getLoanEligibility() {
		if (yearsWorked > 5) {
			if (sal >= 1500000) {
				System.out.println("Loan Granted: 7 lakhs");
			} else if (sal >= 1000000) {
				System.out.println("Loan Granted: 5 lakhs");
			} else if (sal >= 600000) {
				System.out.println("Loan Granted: 2 lakhs");
			} else {
				System.out.println("Loan Not Granted: Salary is less than 6 lakhs");
			}
		} else {
			System.out.println("Loan Not Granted: Employee has worked for less than 5 years");
		}
	}
}

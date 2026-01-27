package EmployeePaymentSystem;

public abstract class Employee {
	 String name; 
	 int employeeId;
	 
	 public Employee(String name, int employeeId) {
		 this.name = name;
	     this.employeeId = employeeId;
	  }
	 
	 public abstract double getPayment();
}

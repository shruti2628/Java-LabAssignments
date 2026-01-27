package EmployeePaymentSystem;

import java.util.ArrayList;

public class EmployeeApp {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new SalariedEmployee("Shruti", 101, 8000));
        employees.add(new HourlyEmployee("Amit", 102, 40, 200));
        employees.add(new CommissionEmployee("Neha", 103, 10, 50000));

        for (Employee emp : employees) {
            System.out.println("ID: " + emp.employeeId +", Name: " + emp.name + ", Weekly Payment: ₹" + emp.getPayment());
        }
    }
}


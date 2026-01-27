package UnifiedPaymentSystem;

import java.util.ArrayList;

public class PaymentApp {

    public static void main(String[] args) {

        ArrayList<Payable> payments = new ArrayList<>();

        payments.add(new Invoice(101, "Laptop", 2, 50000));
        payments.add(new Invoice(102, "Printer", 1, 15000));

        payments.add(new SalariedEmployee(1, "Amit", 60000));
        payments.add(new HourlyEmployee(2, "Riya", 120, 300));

        for (Payable p : payments) {
            System.out.println(p);
        }
    }
}

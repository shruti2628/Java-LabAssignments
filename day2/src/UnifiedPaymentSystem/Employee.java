package UnifiedPaymentSystem;

public abstract class Employee implements Payable {

    protected int empId;
    protected String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }
}

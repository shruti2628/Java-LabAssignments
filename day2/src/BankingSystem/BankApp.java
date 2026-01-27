package BankingSystem;

public class BankApp {
	public static void main(String[] args) {

        SavingsAccount sa = new SavingsAccount("Shruti", 101, 10000);
        sa.deposit(2000);
        sa.withdraw(4000);
        System.out.println("Savings Balance with interest: " + sa.getBalance());

        CurrentAccount ca = new CurrentAccount("Amit", 201, 5000, 12345, 3000);
        ca.withdraw(7000);   // allowed (uses overdraft)
        ca.withdraw(2000);   // exceeds overdraft
        System.out.println("Current Balance: " + ca.getBalance());
    }
}

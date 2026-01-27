package BankingSystem;

public class CurrentAccount extends Account{
	private int tradeLicenseNumber;
	private double overdraft;
	 public CurrentAccount(String name, int accountNumber, double accountBalance, int tradeLicenseNumber, double overdraft) {
		super(name, accountNumber, accountBalance);
		this.tradeLicenseNumber = tradeLicenseNumber;
		this.overdraft = overdraft;
	 }

	
	public double getBalance() {
		return super.getAccountBalance();
	}
	
	@Override
	public void withdraw(double amount) {
		if (amount<=super.getAccountBalance()+overdraft) {
			setAccountBalance(getAccountBalance()-amount);
			System.out.println("Withdrawal successful.");
		}
		else {
			System.out.println("Withdrawal exceeds overdraft limit.");
		}
	}
}

package BankingSystem;

public class SavingsAccount extends Account {
	int interest = 5;
	int MinimumBalanceAllowed= 5000;
	public SavingsAccount(String name, int accountNumber, int accountBalance) {
		super(name, accountNumber, accountBalance);
	}
	double maxWithdrawLimit = getAccountBalance();
	public double getBalance() {
		return super.getAccountBalance() + (super.getAccountBalance() * interest / 100);
	}
	
	@Override
	public void withdraw(double amount) {
		double balanceLeft = getAccountBalance()-amount;
		if (amount<=maxWithdrawLimit && balanceLeft>=5000) {
			setAccountBalance(balanceLeft);	
		}
		else {
			System.out.println("Error. Exceeds max withdraw limits.");
		}
	}
}

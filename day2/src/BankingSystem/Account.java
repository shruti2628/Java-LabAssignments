package BankingSystem;

public class Account {
	private String name;
	private int accountNumber;
	private double accountBalance;
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}



	public double getAccountBalance() {
		return accountBalance;
	}



	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}



	public Account(String name, int accountNumber, double accountBalance) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	
	
	
	public void deposit(double amount) {
		accountBalance+=amount;
	}
	
	public void withdraw(double amount) {
		accountBalance-=amount;
	}
}

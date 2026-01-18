package synchronizationEnsuringConsistentAccountBalance;

public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

//    // Notsynchronized
//    public void addAmount(double amount) {
//        balance = balance + amount;
//    }
//
//    // Notsynchronized
//    public void subtractAmount(double amount) {
//        balance = balance - amount;
//    }
    public synchronized void addAmount(double amount) {
        balance = balance + amount;
    }

    public synchronized void subtractAmount(double amount) {
        balance = balance - amount;
    }

}


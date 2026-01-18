package synchronizationEnsuringConsistentAccountBalance;

public class BankApp {

    public static void main(String[] args) {

        Account account = new Account(10000);

        Thread bankThread =
                new Thread(new Bank(account), "Bank");
        Thread companyThread =
                new Thread(new Company(account), "Company");

        bankThread.start();
        companyThread.start();

        try {
            bankThread.join();
            companyThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Balance: " + account.getBalance());
    }
}

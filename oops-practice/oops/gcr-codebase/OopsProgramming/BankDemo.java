class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        totalAccounts++;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Withdrawal Failed! Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        }
    }

    public void getStatement() {
        System.out.println("\n----- Account Statement -----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Current Balance:" + balance);
        System.out.println("---");
    }
    public static int getTotalAccounts() {
        return totalAccounts;
    }
}
public class BankDemo {

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("A101", "Rahul", 10000);
        BankAccount acc2 = new BankAccount("A102", "Priya", 15000);
        BankAccount acc3 = new BankAccount("A103", "Aman", 20000);

        System.out.println("\nTransactions for Rahul:");
        acc1.deposit(2000);
        acc1.withdraw(1500);
        acc1.deposit(3000);
        acc1.withdraw(5000);
        acc1.withdraw(10000);

        System.out.println("\nTransactions for Priya:");
        acc2.deposit(5000);
        acc2.withdraw(2000);
        acc2.withdraw(1000);
        acc2.deposit(1500);
        acc2.withdraw(25000);

        System.out.println("\nTransactions for Aman:");
        acc3.withdraw(3000);
        acc3.deposit(4000);
        acc3.withdraw(5000);
        acc3.deposit(2500);
        acc3.withdraw(1000);

        acc1.getStatement();
        acc2.getStatement();
        acc3.getStatement();

        System.out.println("\nTotal Accounts Created: "
                + BankAccount.getTotalAccounts());
    }
}
import java.util.ArrayList;

public class BankAccountDemo {

    static class BankAccount {

        private int accountNumber;
        private String holder;
        private double balance;

        private ArrayList<String> statement;

        static int totalAccounts = 0;

        public BankAccount(int accountNumber, String holder, double balance) {
            this.accountNumber = accountNumber;
            this.holder = holder;
            this.balance = balance;
            statement = new ArrayList<>();
            totalAccounts++;
        }

        public void deposit(double amount) {
            balance += amount;
            statement.add("Deposited: " + amount);
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                statement.add("Withdraw Failed: " + amount + " (Insufficient Balance)");
                System.out.println("Overdraft not allowed for Account " + accountNumber);
            } else {
                balance -= amount;
                statement.add("Withdrawn: " + amount);
            }
        }

        public void getStatement() {
            System.out.println("\nAccount Number: " + accountNumber);
            System.out.println("Holder: " + holder);
            System.out.println("Balance: " + balance);

            System.out.println("Transactions:");
            for (String s : statement) {
                System.out.println(s);
            }
        }

        public static int getTotalAccounts() {
            return totalAccounts;
        }
    }

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount(101, "Palak", 10000);
        BankAccount acc2 = new BankAccount(102, "Aman", 15000);
        BankAccount acc3 = new BankAccount(103, "Riya", 20000);


        acc1.deposit(2000);
        acc1.withdraw(1000);
        acc1.deposit(500);
        acc1.withdraw(3000);
        acc1.withdraw(20000);


        acc2.deposit(1000);
        acc2.withdraw(2000);
        acc2.deposit(3000);
        acc2.withdraw(1000);
        acc2.deposit(500);


        acc3.withdraw(5000);
        acc3.deposit(4000);
        acc3.withdraw(2000);
        acc3.deposit(1000);
        acc3.withdraw(500);

        acc1.getStatement();
        acc2.getStatement();
        acc3.getStatement();

        System.out.println("\nTotal Accounts Created: "
                + BankAccount.getTotalAccounts());
    }
}
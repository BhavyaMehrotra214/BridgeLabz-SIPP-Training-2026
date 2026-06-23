public class BankTransactionSystem {
    double balance = 5000;
    void withdraw(double amount)
            throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance!");
        }

        balance -= amount;

        System.out.println(
                "Withdrawal successful, new balance: "
                        + balance);
    }

    public static void main(String[] args) {

        BankTransactionSystem account =
                new BankTransactionSystem();

        try {

            account.withdraw(7000);

        } catch (InsufficientBalanceException e) {

            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }
}
public class BankDemo {
    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount();
        savings.setAccountNumber("SA101");
        savings.setHolderName("Nandini");
        savings.setBalance(50000);
        savings.setInterestRate(5);

        savings.deposit(10000);
        savings.withdraw(5000);

        savings.displayAccountDetails();
        System.out.println("Interest: " + savings.calculateInterest());

        System.out.println();

        CurrentAccount current = new CurrentAccount();
        current.setAccountNumber("CA101");
        current.setHolderName("Riya");
        current.setBalance(40000);
        current.setMonthlyBonusRate(2);

        current.deposit(5000);
        current.withdraw(2000);

        current.displayAccountDetails();
        System.out.println("Interest: " + current.calculateInterest());
    }
}
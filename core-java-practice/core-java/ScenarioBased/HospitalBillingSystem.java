class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
public class HospitalBillingSystem {
    public static double calculateBill(double totalBill, int items) {
        return totalBill / items;
    }
    public static void processPayment(double billAmount, double amountPaid)
            throws InsufficientFundsException {
        if (amountPaid < billAmount) {
            throw new InsufficientFundsException(
                    "Payment Failed: Insufficient funds. Need ₹" +
                            (billAmount - amountPaid) + " more.");
        }
        System.out.println("Payment Successful!");
    }
    public static void main(String[] args) {
        String[] patients = {"Amit", "Neha", "Rahul"};
        try {
            double averageBill = calculateBill(5000, 0);
            System.out.println("Average Bill: ₹" + averageBill);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero. Number of items cannot be zero.");
        }
        try {
            System.out.println("Patient: " + patients[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index selected.");
        }
        try {
            String input = "ABC123";
            int patientId = Integer.parseInt(input);
            System.out.println("Patient ID: " + patientId);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format entered.");
        }
        try {
            processPayment(5000, 3000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Hospital Billing System Running Safely...");
    }
}
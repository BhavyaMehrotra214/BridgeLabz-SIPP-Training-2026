interface LuggageScanner {

    void scanLuggage(String name);

    default void displaySecurityGuidelines() {
        System.out.println("Check luggage before boarding.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo.length() == 8;
    }
}

interface PassportVerifier {

    void verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Carry a valid passport.");
    }
}

public class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    public void scanLuggage(String name) {
        System.out.println(name + "'s luggage scanned.");
    }

    public void verifyPassport(String passportNo) {
        if (LuggageScanner.isPassportNumberValid(passportNo))
            System.out.println("Passport Verified");
        else
            System.out.println("Invalid Passport");
    }

    // Resolve conflict
    public void displaySecurityGuidelines() {
        System.out.println("Follow all airport security rules.");
    }

    public static void main(String[] args) {

        String[] passengers = {"Aman", "Riya", "Rahul"};
        String[] passports = {"AB123456", "XY12", "CD987654"};

        AirportSecuritySystem a = new AirportSecuritySystem();

        a.displaySecurityGuidelines();
        System.out.println();

        for (int i = 0; i < passengers.length; i++) {

            System.out.println("Passenger: " + passengers[i]);
            a.scanLuggage(passengers[i]);

            if (LuggageScanner.isPassportNumberValid(passports[i])) {
                System.out.println("Can Board Flight\n");
            } else {
                System.out.println("Cannot Board Flight\n");
            }
        }
    }
}

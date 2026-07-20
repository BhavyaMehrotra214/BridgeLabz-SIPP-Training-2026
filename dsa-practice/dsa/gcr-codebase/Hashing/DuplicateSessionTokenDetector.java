import java.util.HashSet;

public class DuplicateSessionTokenDetector {

    static boolean hasDuplicateToken(String[] tokens) {

        HashSet<String> seen = new HashSet<>();

        for (String token : tokens) {

            if (!seen.add(token)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] tokens = {
                "ABC123",
                "XYZ456",
                "PQR789",
                "ABC123"
        };

        if (hasDuplicateToken(tokens)) {
            System.out.println("Duplicate Token Found");
        } else {
            System.out.println("No Duplicate Token");
        }
    }
}
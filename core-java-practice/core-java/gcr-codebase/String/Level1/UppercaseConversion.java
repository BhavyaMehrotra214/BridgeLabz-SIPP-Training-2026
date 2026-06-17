import java.util.Scanner;
public class UppercaseConversion {
    static String convertToUpper(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }

            result += ch;
        }

        return result;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String userResult = convertToUpper(text);
        String builtInResult = text.toUpperCase();
        System.out.println("User Result = " + userResult);
        System.out.println("Built In Result = " + builtInResult);
        System.out.println("Match = " + compareStrings(userResult, builtInResult));

        sc.close();
    }
}
import java.util.Scanner;
public class LowerCaseConversion {
    static String convertToLower(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
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

        String userResult = convertToLower(text);
        String builtInResult = text.toLowerCase();
        System.out.println("User Result = " + userResult);
        System.out.println("Built In Result = " + builtInResult);
        System.out.println(compareStrings(userResult, builtInResult));
        sc.close();
    }
}
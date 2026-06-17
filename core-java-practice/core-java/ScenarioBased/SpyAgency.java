import java.util.Scanner;
public class SpyAgency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter secret message: ");
        String msg = sc.nextLine();
        String reverse = "";
        for (int i = msg.length() - 1; i >= 0; i--) {
            reverse += msg.charAt(i);
        }

        System.out.println("Reversed Message: " + reverse);
        if (msg.equalsIgnoreCase(reverse)) {
            System.out.println("Message is a Palindrome");
        } else {
            System.out.println("Message is Not a Palindrome");
        }
        int vowels = 0, consonants = 0;

        for (int i = 0; i < msg.length(); i++) {
            char ch = Character.toLowerCase(msg.charAt(i));

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.print("Enter first intercepted message: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second intercepted message: ");
        String s2 = sc.nextLine();

        s1 = s1.toLowerCase().replace(" ", "");
        s2 = s2.toLowerCase().replace(" ", "");
        if (isAnagram(s1, s2)) {
            System.out.println("Messages are Anagrams");
        } else {
            System.out.println("Messages are Not Anagrams");
        }
        System.out.print("Enter surveillance log: ");
        String log = sc.nextLine();

        char result = firstNonRepeating(log);

        if (result != '\0') {
            System.out.println("First Non-Repeating Character: " + result);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        sc.close();
    }
    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);

        return java.util.Arrays.equals(arr1, arr2);
    }
    static char firstNonRepeating(String str) {
        for (int i = 0; i < str.length(); i++) {
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }
            if (count == 1) {
                return str.charAt(i);
            }
        }
        return '\0';
    }
}
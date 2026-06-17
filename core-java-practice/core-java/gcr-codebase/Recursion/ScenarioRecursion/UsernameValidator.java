public class UsernameValidator {
    public static boolean isValidUsername(String s, int i) {
        if (i == s.length()) {
            return true;
        }
        char ch = s.charAt(i);
        if (ch < 'a' || ch > 'z') {
            return false;
        }
        return isValidUsername(s, i + 1);
    }
    public static void main(String[] args) {
        String s1 = "abcdxyz";
        String s2 = "abcD123";
        System.out.println(isValidUsername(s1, 0)); // true
        System.out.println(isValidUsername(s2, 0)); // false
    }

}
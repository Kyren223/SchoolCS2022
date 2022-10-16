package holidays.sukkot;

public class Palindrom {

    public static void main(String[] args) {

    }

    public static boolean loopPalindrome(String s) {
        boolean isPalindrome = true;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            boolean isPreEqualsSuf = chars[i] == chars[chars.length - 1 -i];
            if (!isPreEqualsSuf) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static boolean recursivePalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        boolean isPreEqualSuf = s.toCharArray()[0] == s.toCharArray()[s.length() - 1];
        return isPreEqualSuf && recursivePalindrome(s.substring(1, s.length() - 1));
    }
}

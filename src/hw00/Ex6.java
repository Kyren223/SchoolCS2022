package hw00;

import java.util.Arrays;

public class Ex6 {

    public static void main(String[] args) {

    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverse2(String s) {
        char[] chars = s.toCharArray();
        char[] reversedChars = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            reversedChars[i] = chars[chars.length - 1 - i];
        }

        return Arrays.toString(reversedChars);
    }

}

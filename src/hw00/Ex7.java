package hw00;

public class Ex7 {

    public static void main(String[] args) {

    }

    public static boolean palindrom(String s) {
        return s.equalsIgnoreCase(Ex6.reverse(s));
    }
}

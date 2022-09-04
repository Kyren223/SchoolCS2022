package hw00;

public class Ex2 {

    public static void main(String[] args) {

    }

    public static String getPrefixAndSuffix(String s) {
        String[] words = s.split(" ");
        return words[0] + " " + words[words.length - 1];
    }
}

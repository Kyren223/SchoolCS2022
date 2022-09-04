package hw00;

public class Ex4 {

    public static void main(String[] args) {

    }

    public static int countIs(String s) {
        int counter = 0;
        String[] words = s.split(" ");
        for (String word : words) {
            if (word.equalsIgnoreCase("is")) counter++;
        }
        return counter;
    }
}

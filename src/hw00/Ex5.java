package hw00;

public class Ex5 {

    public static void main(String[] args) {

    }

    public static int countAEIOU(String s) {
        int counter = 0;

        char[] chars = {'a', 'e', 'i', 'o', 'u'};

        for (char c : s.toCharArray()) {
            for (char ch : chars) {
                if (c == ch) counter++;
            }
        }

        return counter;
    }

}

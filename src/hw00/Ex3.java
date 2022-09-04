package hw00;

public class Ex3 {

    public static void main(String[] args) {

    }

    public static String getAcronym(String s) {
        String[] words = s.split(" ");
        String acronym = "";

        for (String word : words) {
            if (word.toCharArray()[0] >= 'A' && word.toCharArray()[0] <= 'Z') {
                acronym += word.toCharArray()[0];
            }
        }

        return acronym;
    }
}

package holidays.summer;

public class Ex3 {

    public static void main(String[] args) {

    }

    public static String getAcronym(String s) {
        String[] words = s.split(" ");
        StringBuilder acronym = new StringBuilder();

        for (String word : words) {
            if (word.toCharArray()[0] >= 'A' && word.toCharArray()[0] <= 'Z') {
                acronym.append(word.toCharArray()[0]);
            }
        }

        return acronym.toString();
    }
}

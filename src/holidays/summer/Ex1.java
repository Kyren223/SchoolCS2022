package holidays.summer;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {

    }

    public static int checkFamilyName(int number) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        for (int i = 0; i < number; i++) {
            String name = scanner.next();
            if (name.contains("cohen")) counter++;
        }

        return counter;
    }
}

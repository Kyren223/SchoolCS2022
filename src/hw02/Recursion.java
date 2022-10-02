package hw02;

public class Recursion {
    public static void main(String[] args) {
        int num1 = 542215;
        int num2 = 1248135;
        int num3 = 28648246;
        int num4 = 15;

        System.out.println("Recursive Sum of " + num1 + ": " + getSumRecursively(num1));
        System.out.println("Count of even digits of " + num2 + ": " + getEvenDigitsCount(num2));
        System.out.println("Is even digit - " + num3 + ": " + isEvenDigits(num3));
        System.out.println("Factorial of " + num4 + ": " + getFactorial(num4));

    }

    public static int getSumRecursively(int num) {
        if (num < 10) return num;
        return num % 10 + getSumRecursively(num / 10);
    }

    public static int getEvenDigitsCount(int num) {
        if (num < 10) return num % 2 == 0 ? 1 : 0;
        return ((num % 10) % 2 == 0 ? 1 : 0) + getEvenDigitsCount(num / 10);
    }

    public static boolean isEvenDigits(int num) {
        if (num < 10) return num % 2 == 0;
        return (num % 10) % 2 == 0 && isEvenDigits(num / 10);
    }

    public static long getFactorial(long num) {
        if (num <= 1) return 1;
        return num * getFactorial(num - 1);
    }
}


package holidays.sukkot;

public class MysteryFunctions {

    public static void main(String[] args) {
        //System.out.println(mystery4(3,7));

        int[] arr = new int[] {10, 20, 30, 40, 50};
        System.out.println(bonus(arr, 3));
    }

    public static void mystery1() {

        /*

        3892:
            3892 < 10 = false
            max(2, X1)

        X1 = 389:
            389 < 10 = false
            max(9, X2)

        X2 = 38:
            38 < 10 = false
            max(8, X3)

        X3 = 3:
            3 < 10 = true
            X3 = 3

        max(2, max(9, max(8, max(3)))) = 9

        RETURNS THE LAREGEST DIGIT IN THE NUMBER
         */
    }

    public static void mystery2() {

        /*

        3241:
            3241 < 10 = false
            temp = X1
            i = ?
            return 1 * ? + X1

        X1 = 324:
            324 < 10 = false
            temp = X2
            i = ?
            return 4 * ? + X2

        X2 = 32:
            32 < 10 = false
            i = ?
            return 2 * ? + X3

        X3 = 3:
            3 < 10 = true
            return 3

        i = 1 (1 <= 3) 1*=10 = 10
        return 2 * 10 + 3

        i = 100
        return 4 * 100 + 23

        i = 1000
        return 1 * 1000 + 423

        return 1423

        REVERSES THE NUMBER
         */

    }

    public static void mystery3() {

        /*

        Checks if a number is a prime number

        example:
        n = 7
        div = ~3
        7 % 3 = 1
        div = 2
        7 % 2 = 1
        1 == 1 -> true (prime)

        example 2:
        n = 9
        div = 3
        9 % 3 = 0 -> false (not prime)

         */

    }

    public static int mystery4(int n, int m) {

        /*

        n=10, m=3
        10 > 3 ? true -> return 3

        ----------------------

        n=3 m=10
        3 > 10 ? false ->

        n=10-3=7 m=10
        7>10 ? false ->

        n=10-7=3 m=10 ->
        3 > 10 ? false ->

        n=10-3=7 m=10 ->
        7 > 10 ? false -> REPEAT

        Infinite loop when n < m, otherwise return m
         */

        // To confirm it does actually infinitely loop
        if (n > m) {
            return m;
        } else {
            return mystery4(m-n, m);
        }

    }

    public static float bonus(int[] a, int k) {
        float x;
        if (k == 1) return (a[0]);
        x = bonus(a, k-1) * (k-1);
        return ((a[k-1] + x) / k);

        // Returns the average of the numbers between 0 and k-1

    }
}

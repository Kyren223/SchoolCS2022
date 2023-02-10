package bagrut.summer2022;

public class Ex1 {
    
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 0, 2};
        System.out.println(isPerfectArray(arr));
    }
    
    public static int[] multiply(int[] arr1, int[] arr2) {
        int k = Math.min(arr1.length, arr2.length);
        int m = Math.max(arr1.length, arr2.length);
        int[] arr = new int[m];
        
        for (int i = 0; i < k; i++) {
            arr[i] = arr1[i] * arr2[i];
        }
    
        for (int i = k; i < m; i++) {
            arr[i] = arr1.length > arr2.length ? arr1[i] : arr2[i];
        }
        
        return arr;
    }
    
    public static boolean isPerfectArray(int[] arr) {
        boolean reachedZero = false;
        int i = 0;
        while (arr[i] != -1) {
            int oldI = i;
            if (arr[i] == 0) reachedZero = true;
            else i = arr[i];
            arr[oldI] = -1;
        }
    
        for (int k : arr) {
            if (k != -1) return false;
        }
        
        return reachedZero;
    }
}

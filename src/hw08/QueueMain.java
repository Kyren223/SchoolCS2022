package hw08;

import hw07.Queue;

import java.util.Scanner;

public class QueueMain {
    
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        Scanner scanner = new Scanner(System.in);
        
        int x = 0;
        while (x != 999) {
            System.out.print("Enter number: ");
            x = scanner.nextInt();
            q.insert(x);
        } // O(N)
        System.out.println(q);
        sort(q);
        System.out.println(q);
        
    }
    
    // O(N)
    public static boolean contains(Queue<Integer> q, Integer num) {
        Queue<Integer> copy = new Queue<>();
        boolean isFound = false;
        
        while (!q.isEmpty()) {
            Integer x = q.remove();
            copy.insert(x);
            if (x.intValue() == num.intValue()) isFound = true;
        }
        
        while (!copy.isEmpty()) {
            Integer x = copy.remove();
            q.insert(x);
        }
        return isFound;
    }
    
    // O(N)
    public static int getGreatest(Queue<Integer> q) {
        Queue<Integer> copy = new Queue<>();
        int greatest = q.head();
    
        while (!q.isEmpty()) {
            int x = q.remove();
            copy.insert(x);
            if (x > greatest) greatest = x;
        }
    
        while (!copy.isEmpty()) {
            int x = copy.remove();
            q.insert(x);
        }
        return greatest;
    }
    
    // O(N^2)
    public static void sort(Queue<Integer> q) {
        Queue<Integer> copy = new Queue<>();
        Queue<Integer> sortedQ = new Queue<>();
    
        // Runs O(N) times
        while (!q.isEmpty()) {
            // Find lowest O(N)
            int lowest = q.head();
            while (!q.isEmpty()) {
                int x = q.remove();
                copy.insert(x);
                if (x < lowest) lowest = x;
            }
            
            while (!copy.isEmpty()) {
                int x = copy.remove();
                if (x == lowest) { // Don't add the lowest to q
                    sortedQ.insert(lowest);
                } else q.insert(x);
            }
            System.out.println("Sorted Q: " + sortedQ.toString());
            System.out.println("Copy Q: " + copy.toString());
        }
        // Copy over sorted array
        while (!sortedQ.isEmpty()) q.insert(sortedQ.remove());
    }
    
    // O(N)
    public static int countSame(Queue<Integer> q) {
        int last = 0;
        int i = 0;
        int counter = 0;
        Queue<Integer> copy = new Queue<>();
    
        if (!q.isEmpty()) {
            int x = q.remove();
            copy.insert(x);
            i++;
            last = x;
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            copy.insert(x);
            
            if (x != last) {
                if (i > 1) counter++;
                i = 1;
            } else i++;
            last = x;
        }
    
        while (!copy.isEmpty()) {
            int x = copy.remove();
            q.insert(x);
        }
        
        
        return counter;
    }
    
}

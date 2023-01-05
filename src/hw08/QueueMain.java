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
        
        
    }
    
    // O(N)
    public boolean contains(Queue<Integer> q, Integer num) {
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
    public int getGreatest(Queue<Integer> q) {
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
    
    //
    public void sort(Queue<Integer> q) {
    
    }
    
    public int countSame(Queue<Integer> q) {
        int last = 0;
        int counter = 0;
        Queue<Integer> copy = new Queue<>();
    
        while (!q.isEmpty()) {
            int x = q.remove();
            copy.insert(x);
        }
    
        while (!copy.isEmpty()) {
            int x = copy.remove();
            q.insert(x);
        }
        
        
        return counter;
    }
    
}

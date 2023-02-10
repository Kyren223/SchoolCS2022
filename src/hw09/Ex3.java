package hw09;

import data.Queue;

public class Ex3 {
    public static void main(String[] args) {
    
    }
    
    public Queue<Integer> reverseQueue(Queue<Integer> q) {
        Queue<Integer> newQ = new Queue<>();
        reverseQueueRecursively(q, newQ);
        return newQ;
    }
    
    public int reverseQueueRecursively(Queue<Integer> q, Queue<Integer> r) {
        return 2;
    }
}

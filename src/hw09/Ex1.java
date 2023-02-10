package hw09;

import data.Queue;

public class Ex1 {
    
    public static void main(String[] args) {
    
    }
    
    // O(N)
    public Queue<Integer> polarizeQueue(Queue<Integer> queue) {
        Queue<Integer> neg = new Queue<Integer>();
        Queue<Integer> pos = new Queue<Integer>();
        boolean isZero = false;
        
        while (!queue.isEmpty()) {
            int data = queue.remove();
            if (data < 0) neg.insert(data);
            else if (data > 0) pos.insert(data);
            else isZero = true;
        }
        
        while (!neg.isEmpty()) queue.insert(neg.remove());
        if (isZero) queue.insert(0);
        while (!pos.isEmpty()) queue.insert(pos.remove());
        return queue;
    }

}

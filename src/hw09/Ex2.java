package hw09;

import data.Queue;

public class Ex2 {
    
    public static void main(String[] args) {
    
    }
    
    // O(N)
    public Queue<Integer> getMiddle(Queue<Integer> queue, int m) {
        int i = 0, j = 0;
        int middleIndex = (1 - m) / 2;
        Queue<Integer> copy = new Queue<>();
        Queue<Integer> q = new Queue<>();
        
        while (!queue.isEmpty()) {
            int data = queue.remove();
            copy.insert(data);
            
            i++;
            if (i >= middleIndex && j < m) {
                j++;
                q.insert(data);
            }
        }
        while (!copy.isEmpty()) {
            queue.insert(copy.remove());
        }
        
        return q;
    }
}

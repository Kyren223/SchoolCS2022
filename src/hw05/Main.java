package hw05;

import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        Node<Line> head = new Node<>(new Line(0,0,0,0));
        Random random = new Random();
        
        Node<Line> curr = head;
        for (int i = 0; i < 5; i++) {
            curr.setNext(new Node<>(new Line(
                    random.nextInt(1, 10), random.nextInt(1, 10), random.nextInt(1, 10), random.nextInt(1, 10))));
            
            curr = curr.getNext();
        }
    
        System.out.println(head);
        System.out.println(calcAverage(head));
        
    }
    
    public static double calcAverage(Node<Line> head) {
        Node<Line> curr = head;
        double sum = 0;
        int c = 0;
        while (curr != null) {
            sum += curr.getValue().getLineLength();
            c++; // CPP pOGGERS
            curr = curr.getNext();
        }
        return sum / c;
    }
}

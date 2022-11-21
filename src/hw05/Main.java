package hw05;

import java.util.Random;

public class Main {
    
    public static final int cSize = 100;
    public static void main(String[] args) {
        
        Node<Character> cHead = createCharNodes(cSize);
        System.out.println(cHead);
        System.out.println("Amount zipped: " + zip(cHead));
        System.out.println(cHead);
        
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
    
    
    public static Character getRandomChar() {
        final int letters = 24;
        final int aLetter = 97;
        Random random = new Random();
        int num = random.nextInt(letters) + aLetter;
        return (char) num;
    }
    private static Node<Character> createCharNodes(int size) {
        Node<Character> head = new Node<>(getRandomChar());
        Node<Character> curr = head;
        for (int i = 1; i < size; i++) {
            curr.setNext(new Node<>(getRandomChar()));
            curr = curr.getNext();
        } return head;
    }
    
    public static void removeNext(Node<Character> curr) {
        if (curr.getNext() == null) return;
        curr.setNext(curr.getNext().getNext());
    }
    
    public static int zip(Node<Character> head) {
        int counter = 0;
        Node<Character> curr = head;
        while (curr.getNext() != null) {
            if (curr.getValue() == curr.getNext().getValue()) {
                removeNext(curr);
                counter++;
            }
            
            curr = curr.getNext();
        } return counter;
    }
}

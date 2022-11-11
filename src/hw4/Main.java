package hw4;

import java.util.Random;

public class Main {

    // Consts! Very important!
    public static final int SIZE = 5;
    public static final int MIN = 0;
    public static final int MAX = 223;

    public static void main(String[] args) {
        IntNode head = createLinkedList(SIZE);
        System.out.println("[" + head + "]");
        System.out.println("Size: " + getLinkedListLength(head));
        System.out.println("Max value: " + getMaxValue(head));

        sortLinkedList(head);
        System.out.println("Sorted List: \n" + "[" + head + "]");

        int num = new Random().nextInt(MIN, MAX + 1);
        head = insertToSortedLinkedList(head, num);
        System.out.println("Inserting " + num + ": \n" + "[" + head + "]");
    }

    public static void sortLinkedList(IntNode head) {
        IntNode curr;
        boolean swapped = true;

        while (swapped) {
            curr = head;
            swapped = false;
            while (curr.getNext() != null) {
                if (curr.getValue() > curr.getNext().getValue()) {
                    swapped = true;
                    // Swap
                    int temp = curr.getValue();
                    curr.setValue(curr.getNext().getValue());
                    curr.getNext().setValue(temp);
                }

                curr = curr.getNext();
            }
        }
    }

    public static IntNode insertToSortedLinkedList(IntNode head, int value) {
        IntNode curr = head;

        // In case the new value is in the head
        if (curr.getValue() > value) {
            return new IntNode(value, curr);
        }

        while (curr.getNext() != null) {
            if (curr.getValue() <= value && value <= curr.getNext().getValue()) {
                curr.insertNode(value);
                return head; // Very important, we don't want to keep inserting
            }

            curr = curr.getNext();
        }
        if (curr.getValue() < value) curr.insertNode(value);

        return head;
    }

    public static int getMaxValue(IntNode head) {
        IntNode curr = head;
        int maxValue = curr.getValue();
        while (curr != null) {
            if (curr.getValue() > maxValue) maxValue = curr.getValue();
            curr = curr.getNext();
        }
        return maxValue;
    }

    public static int getLinkedListLength(IntNode head) {
        int counter = 0;
        IntNode curr = head;
        while (curr != null) {
            counter++;
            curr = curr.getNext();
        }
        return counter;
    }

    public static IntNode createLinkedList(int size) {
        Random random = new Random();

        IntNode head = new IntNode(random.nextInt(MIN, MAX + 1));
        IntNode curr = head;

        for (int i = 0; i < size - 1; i++) {
            curr.setNext(new IntNode(random.nextInt(MIN, MAX + 1)));
            curr = curr.getNext();
        }

        return head;
    }
}

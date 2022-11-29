package hw06;

import hw05.Node;

public class Main {
    
    public static void main(String[] args) {
        /*
        Question 1:
        chain1 and chain2 will stay the same
        chain2 will be added to the last chain
        
        Question 2:
        a.
        true - 5 -> null
        false - 5 -> 8 -> 7
        b.
        true - 2 adjacent nums needs to have different signs (neg/pos)
        false - When it doesn't happen
        base assumption: chain != null
        
        Question 3:
        void
         */
    }
    
    public static void disconnect(Node<Integer> chain1, Node<Integer> chain2) {
        Node<Integer> commonChain = null;
        
        // O(N^2)
        Node<Integer> curr1 = chain1;
        while (curr1 != null) {
            Node<Integer> curr2 = chain2;
            while (curr2 != null) {
                if (curr1 == curr2) {
                    commonChain = curr1;
                    break;
                }
                curr2 = curr2.getNext();
            }
            if (commonChain != null) break;
            curr1 = curr1.getNext();
        }
        
        // O(N)
        Node<Integer> curr = chain1;
        while (curr != null) {
            if (curr.getNext() == commonChain) {
                break;
            }
            curr = curr.getNext();
        }
        
        // O(N)
        while (curr != null && commonChain != null) {
            curr.setNext(new Node<Integer>(commonChain.getValue())); // Copy over values
            curr = curr.getNext();
            commonChain = commonChain.getNext();
        }
        
        
        
    }
}

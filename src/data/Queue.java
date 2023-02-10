package data;
import data.Node;

public class Queue<T> {
    
    private Node<T> first;
    private Node<T> last;
    private int size; // Just for convenience
    
    public Queue() {
        size = 0;
        first = null;
        last = null;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void insert(T x) {
        Node<T> insertionNode = new Node<>(x);
        size++;
        if (last == null) {
            last = insertionNode;
            first = insertionNode;
            return;
        }
        last.setNext(insertionNode);
        last = last.getNext();
    }
    
    public T remove() {
        if (isEmpty()) return null;
        Node<T> deletionNode = first;
        first = first.getNext();
        size--;
        return deletionNode.getData();
    }
    
    public T head() {
        if (isEmpty()) return null;
        return first.getData();
    }
    
    @Override
    public String toString() {
        return first.toString();
    }
}

package hw05;

public class Node<T> {
    
    private T value;
    private Node<T> next;
    
    public Node(T value) {
        this.value = value;
    }
    
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
    
    public T getValue() {
        return value;
    }
    
    public Node<T> getNext() {
        return next;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        String nextString = getNext() != null ? "\n" + getNext().toString() : "";
        return this.getValue().toString() + nextString;
    }
}

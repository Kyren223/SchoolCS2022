package data;

public class Stack<T> {
    private Node<T> head;
    
    public Stack() {
        head = null;
    }
    
    public boolean isEmpty() { return head == null; }
    
    public void push(T data) {
        Node<T> prev = head;
        head = new Node<>(data);
        head.setNext(prev);
    }
    
    public T pop() {
        if (head == null) return null;
        T data = head.getData();
        head = head.getNext();
        return data;
    }
}

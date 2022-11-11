package hw4;

public class IntNode {

    private int value;
    private IntNode next;

    public IntNode(int value) {
        this.value = value;
        this.next = null;
    }

    public IntNode(int value, IntNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public IntNode getNext() {
        return next;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String next = getNext() != null ? ", " + getNext().toString() : "";
        return getValue() + next;
    }

    // Helper functions

    public void removeNode() {
        IntNode curr = this;
        IntNode temp = curr.getNext();
        curr.setNext(temp.getNext());
        temp.setNext(null);
    }

    public void insertNode(int value) {
        IntNode curr = this;
        IntNode temp = new IntNode(value, curr.getNext());
        curr.setNext(temp);
    }


}

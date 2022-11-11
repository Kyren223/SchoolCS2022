package hw4;

public class DoubleNode {

    private double value;
    private DoubleNode next;

    public DoubleNode(double value) {
        this.value = value;
        this.next = null;
    }

    public DoubleNode(double value, DoubleNode next) {
        this.value = value;
        this.next = next;
    }

    public double getValue() {
        return value;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
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
        DoubleNode curr = this;
        DoubleNode temp = curr.getNext();
        curr.setNext(temp.getNext());
        temp.setNext(null);
    }

    public void insertNode(int value) {
        DoubleNode curr = this;
        DoubleNode temp = new DoubleNode(value, curr.getNext());
        curr.setNext(temp);
    }


}

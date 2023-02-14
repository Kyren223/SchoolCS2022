package data;

public class BinaryNode<T> {
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    private T data;
    
    public BinaryNode(T data) {
        left = null;
        right = null;
        this.data = data;
    }
    
    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public BinaryNode<T> getLeft() {
        return left;
    }
    
    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }
    
    public BinaryNode<T> getRight() {
        return right;
    }
    
    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
    
    @Override
    public String toString() {
        String s = String.valueOf(getData());
        if (getLeft() != null) s += ", " + getLeft().toString();
        if (getRight() != null) s += ", " + getRight().toString();
        return s;
    }
}

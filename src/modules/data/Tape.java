package modules.data;

import modules.data.exceptions.TapeException;
import unit4.collectionsLib.BinNode;

public class Tape {
    private BinNode<TapeValue> head;
    
    public Tape(String input) throws TapeException {
        head = new BinNode<>(null, TapeValue.fromEnd(), null);
        right(); // To account for epsilon
        for (char c : input.toCharArray()) {
            write(new TapeValue(c));
            right();
        }
        while (!read().isEnd()) {
            left();
        } right();
    }
    
    public TapeValue read() {
        return head.getValue();
    }
    
    public void write(TapeValue value) throws TapeException {
        if (read().isEnd() && !value.isEnd()) throw new TapeException("Cannot write into the end symbol");
        if (value.isEnd()) throw new TapeException("End symbol is not writable");
        head.setValue(value);
    }

    public void move(Direction dir) throws TapeException {
        if (dir == Direction.LEFT) left();
        else if (dir == Direction.RIGHT) right();
        else throw new TapeException("Invalid direction");
    }
    
    public void left() throws TapeException {
        if (read().isEnd()) throw new TapeException("Cannot go left, end symbol reached");
        // end should block, so moving left is never null!
        head = head.getLeft();
    }
    
    public void right() throws TapeException {
        if (head.getRight() == null) {
            BinNode<TapeValue> rightNode = new BinNode<>(head, TapeValue.fromEmpty(), null);
            head.setRight(rightNode);
        }
        head = head.getRight(); // Can always go right, infinitely
    }

    @Override
    public String toString() {
        return sideString(head.getLeft(), true) +
                "[=" + head.getValue().getValue() + "=]" +
                sideString(head.getRight(), false);
    }

    private String sideString(BinNode<TapeValue> side, boolean isLeft) {
        if (side == null) return "";
        BinNode<TapeValue> nextSide = isLeft ? side.getLeft() : side.getRight();
        String s = "[" + side.getValue().getValue() + "]";
        return isLeft ?
                sideString(nextSide, true) + s : s + sideString(nextSide, false);
    }
}

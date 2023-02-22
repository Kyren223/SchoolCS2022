package modules.data;

import modules.data.exceptions.TapeException;
import unit4.collectionsLib.BinNode;
import unit4.collectionsLib.Node;

public class Tape {
    private BinNode<TapeValue> head;
    
    public Tape(String input) {
        TapeValue value = new TapeValue(TapeValue.END);
        head = new BinNode<>(null, value, null);
        
    }
    
    public TapeValue read() {
        return head.getValue();
    }
    
    public void write(TapeValue value) throws TapeException {
        if (read().isEnd() && !value.isEnd()) throw new TapeException("Cannot write into the end symbol");
        if (value.isEnd()) throw new TapeException("End symbol is not writable");
        head.setValue(value);
    }
    
    public void left() throws TapeException {
        if (read().isEnd()) throw new TapeException("Cannot go left, end symbol reached");
        // end should block, so moving left is never null!
        head = head.getLeft();
    }
    
    public void right() {
        if (head.getRight() == null) {
            BinNode<TapeValue> rightNode = new BinNode<>(head, new TapeValue(TapeValue.EMPTY), null);
        }
        head = head.getRight(); // Can always go right, infinitely
    }
}

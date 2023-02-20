package modules.data;

import unit4.collectionsLib.BinNode;
import unit4.collectionsLib.Node;

public class Tape {
    private BinNode<TapeValue> head;
    
    public Tape() {
        TapeValue value = new TapeValue(TapeValue.END);
        head = new BinNode<>(null, value, null);
        
    }
    
}

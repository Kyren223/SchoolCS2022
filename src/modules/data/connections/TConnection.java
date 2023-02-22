package modules.data.connections;

import modules.data.Direction;
import modules.data.connections.Connection;

public class TConnection extends Connection {
    
    private final char overwriteValue;
    private final Direction dir;
    
    public TConnection(char condition, String toState, char newValue, Direction dir) {
        super(condition, toState);
        this.overwriteValue = newValue;
        this.dir = dir;
    }
    
    public Direction getDir() {
        return dir;
    }
    
    public char getNewValue() {
        return overwriteValue;
    }
}

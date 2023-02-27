package modules.data.connections;

import modules.data.Direction;
import modules.data.TapeValue;
import modules.data.connections.Connection;

public class TConnection extends Connection {
    
    private final TapeValue readValue;
    private final TapeValue writeValue;
    private final Direction dir;
    
    public TConnection(TapeValue readValue, String toState, TapeValue writeValue, Direction dir) {
        super('0', toState);
        this.readValue = readValue;
        this.writeValue = writeValue;
        this.dir = dir;
    }
    
    public boolean pass(TapeValue value) {
        return readValue.getValue().equals(value.getValue());
    }
    
    public Direction getDir() {
        return dir;
    }
    
    public TapeValue getReadValue() {
        return readValue;
    }
    
    public TapeValue getWriteValue() {
        return writeValue;
    }
}

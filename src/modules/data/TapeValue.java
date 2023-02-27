package modules.data;

import modules.data.exceptions.TapeException;

public class TapeValue {
    
    public static final String EMPTY = "<>";
    public static final String END = "|-";
    private String value;
    
    public TapeValue(String value) throws TapeException {
        this.value = value;
        if (!isValueValid()) throw new TapeException("Non-char value");
    }

    public TapeValue(char value) {
        this.value = String.valueOf(value);
    }
    
    public static TapeValue fromEnd() throws TapeException {
        return new TapeValue(END);
    }
    
    public static TapeValue fromEmpty() throws TapeException {
        return new TapeValue(EMPTY);
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) throws TapeException {
        this.value = value;
        if (!isValueValid()) throw new TapeException("Non-char value");
    }

    public void setValue(char value) {
        this.value = String.valueOf(value);
    }
    
    public boolean isEnd() {
        return this.value.equals(END);
    }
    
    public boolean isEmpty() {
        return this.value.equals(EMPTY);
    }
    
    public void setEnd() {
        this.value = END;
    }
    
    public void setEmpty() {
        this.value = EMPTY;
    }

    private boolean isValueValid() {
        return (isEmpty() || isEnd() || value.length() == 1);
    }
}

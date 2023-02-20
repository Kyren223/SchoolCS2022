package modules.data;

public class TapeValue {
    
    public static final String EMPTY = "<>";
    public static final String END = "|-";
    private String value;
    
    public TapeValue(String value) {
        this.value = value;
    }
    
    public TapeValue() {
        this.value = EMPTY;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
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
}

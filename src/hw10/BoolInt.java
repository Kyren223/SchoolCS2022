package hw10;

public class BoolInt {
    private boolean bool;
    private int i;
    
    public BoolInt(boolean bool, int i) {
        this.bool = bool;
        this.i = i;
    }
    
    public boolean isBool() {
        return bool;
    }
    
    public void setBool(boolean bool) {
        this.bool = bool;
    }
    
    public int getInt() {
        return i;
    }
    
    public void setInt(int i) {
        this.i = i;
    }
}

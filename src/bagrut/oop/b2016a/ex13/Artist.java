package bagrut.oop.b2016a.ex13;

public class Artist {
    private String firstName; // Should be protected
    private String secondName;
    private double salary; // Should be protected
    protected static int num; // Should be public
    
    public Artist(double salary, String name) {
    
    }
    
    public Artist(double salary, String firstName, String secondName) {
    
    }
    
    public double calc(double d) {
        return 0;
    }
    
    public double price() { // What about int?
        return 0;
    }
    
    public void print() {
    
    }
    
    public int train() {
        return 5;
    }
}

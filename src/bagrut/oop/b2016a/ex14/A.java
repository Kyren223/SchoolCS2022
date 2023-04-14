package bagrut.oop.b2016a.ex14;

public class A {
    private int x;
    
    public A() {
        this.x = 0;
    }
    
    public A(int x) {
        this.x = x;
    }
    
    public int getX() {
        return x;
    }
    
    public void doubleX() {
        this.x = 2 * getX();
    }
    
    public void tripleX() {
        this.x = 3 * getX();
    }
    
    public void sub() {
        this.x = -1;
    }
    
    public void calc() {
        sub();
    }
    
    public String toString() {
        return "xA="+this.x;
    }
}

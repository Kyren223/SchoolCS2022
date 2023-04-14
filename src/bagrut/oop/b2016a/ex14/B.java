package bagrut.oop.b2016a.ex14;

public class B extends A {
    private int x;
    
    public B() {
        super();
        this.x = 1;
    }
    
    public B(int x) {
        super(x);
        this.x = -x;
    }
    
    public B(int xA, int xB) {
        super(xA);
        this.x = xB;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int baseX() {
        return super.getX();
    }
    
    public void tenTimesX() {
        this.x = 10 * getX();
    }
    
    public void tripleX() {
        this.x = 3 * getX();
    }
    
    public void sub() {
        this.x = x - 2;
    }
    
    public String toString() {
        return super.toString() + " xB="+this.x+";";
    }
}

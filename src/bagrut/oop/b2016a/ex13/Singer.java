package bagrut.oop.b2016a.ex13;

public class Singer extends Artist implements IPerform {

    private int hits;
    
    public Singer(String name, double sal) {
        super(sal, name);
        this.hits = 5;
    }
    
    public Singer(double sal, int hits) {
        super(sal, "Singer Name");
        this.hits = hits;
    }
    
    public Singer(int hits) {
        super(6532.6, "Some", "One");
        this.hits = hits;
    }
    
    public double value() {
        return this.hits * this.price();
    }
    
    public int getNum() {
        return Artist.num;
    }
    
    public double calc(double d) {
        return d * super.calc(10.2);
    }
    
    public void print() {
        super.print();
        System.out.println("Singer");
    }
    
    public void act() {
        System.out.println("I am singing");
    }
    
    
    
}

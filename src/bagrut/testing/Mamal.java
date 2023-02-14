package bagrut.testing;

public class Mamal {
    
    protected int weight;
    
    public Mamal(int weight) {
        this.weight = weight;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public boolean isSame(Mamal other) {
        System.out.println("In Mamal");
        return this == other;
    }
    
}

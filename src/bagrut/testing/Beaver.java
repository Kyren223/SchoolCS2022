package bagrut.testing;

public class Beaver extends Mamal {
    
    public Beaver(int weight) {
        super(weight);
    }
    
    public boolean isSame(Mamal other) {
        return (other instanceof Beaver && this.weight == other.weight);
    }
}

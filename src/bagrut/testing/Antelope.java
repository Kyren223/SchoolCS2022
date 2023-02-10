package bagrut.testing;

public class Antelope extends Mamal {
    
    public Antelope(int weight) {
        super(weight);
    }
    
    public boolean isSame(Antelope other) {
        return this.weight == other.weight;
    }
}

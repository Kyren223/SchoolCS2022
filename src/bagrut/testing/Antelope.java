package bagrut.testing;

public class Antelope extends Mamal {
    
    public Antelope(int weight) {
        super(weight);
    }
    
    public boolean isSame(Antelope other) {
        System.out.println("In Antelope");
        return (other != null) && (this.weight == other.weight);
    }
}

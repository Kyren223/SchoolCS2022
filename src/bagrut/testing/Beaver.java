package bagrut.testing;

public class Beaver extends Mamal {
    
    public Beaver(int weight) {
        super(weight);
    }
    
    @Override
    public boolean isSame(Mamal other) {
        System.out.println("In Beaver");
        return (other != null) && (other instanceof Beaver) && (this.weight == ((Beaver)other).weight);
    }
}

package bagrut.oop.b2018;

public class Resident implements IData {
    private final int RESIDENCE_MULTIPLIER = 10;
    private final double GROUND_MULTIPLIER = 0.5;
    protected String name;
    protected int residenceSurface;
    protected int groundSurface;
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public double getPropertyTax() {
        return residenceSurface * RESIDENCE_MULTIPLIER + groundSurface * GROUND_MULTIPLIER;
    }
}

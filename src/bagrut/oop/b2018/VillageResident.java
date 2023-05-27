package bagrut.oop.b2018;

public class VillageResident extends Resident {
    private final double PERCENTAGE = 0.9;
    
    @Override
    public double getPropertyTax() {
        return super.getPropertyTax() * PERCENTAGE;
    }
}

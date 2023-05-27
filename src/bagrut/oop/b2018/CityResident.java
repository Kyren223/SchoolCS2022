package bagrut.oop.b2018;

public class CityResident extends Resident {
    private final int bonus = 250;
    @Override
    public double getPropertyTax() {
        return super.getPropertyTax() - bonus;
    }
}

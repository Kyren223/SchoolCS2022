package bagrut.oop.b2018;

public class SeniorCityResidence extends CityResident {
    private final int AGE_LIMIT = 60;
    private int age;
    
    @Override
    public double getPropertyTax() {
        int reductionPercentage = age - AGE_LIMIT;
        double percentage = 1 - (reductionPercentage / 100d);
        return super.getPropertyTax() * percentage;
    }
}

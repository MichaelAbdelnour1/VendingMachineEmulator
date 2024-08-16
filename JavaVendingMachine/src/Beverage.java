public class Beverage extends Product {
    private double flOunces;

    public Beverage(double flOunces, String name, double price) throws IllegalArgumentException  {
        super(name, price);
        this.flOunces = flOunces;
        if(flOunces < 0){
            throw new IllegalArgumentException ("flOunces must be a positive number");
        }
    }

    public double getFlOunces() {
        return flOunces;
    }

    public void setFlOunces(double flOunces) {
        this.flOunces = flOunces;
        if(flOunces < 0){
            throw new IllegalArgumentException ("flOunces must be a positive number ");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", flOunces: " + flOunces;
    }
}

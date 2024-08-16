public class Snack extends Product {
    private boolean isVegan;

    public Snack(Boolean isVegan, String name, double price){
        super(name, price);
        this.isVegan = isVegan;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    @Override
    public String toString() {
        return super.toString() + ", Vegan: " + isVegan;
    }
}


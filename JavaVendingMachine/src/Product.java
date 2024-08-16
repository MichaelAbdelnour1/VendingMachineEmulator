public class Product {
    private String name;
    private double price;

    public Product(String name, double price) throws IllegalArgumentException  {
        this.name = name;
        this.price = price;
        if (name == null || price < 0 || name.isEmpty()){
            throw new IllegalArgumentException("Name is empty or price is less then 0");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException  {
        this.price = price;

        if (price < 0){
            throw new IllegalArgumentException ("Price is less then 0");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException  {
        this.name = name;
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException ("Name is empty or null");
        }
    }

    @Override
    public String toString() {
        return "Product name: " + name + ", Price: $" + price;
    }
}


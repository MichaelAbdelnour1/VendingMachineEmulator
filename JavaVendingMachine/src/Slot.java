public class Slot <T extends Product>{
    private int quantity;
    private T product;

    public Slot(int quantity, T product) throws IllegalArgumentException {
        this.quantity = quantity;
        this.product = product;
        if(product == null || quantity < 0){
            throw new IllegalArgumentException("Product cannot be null or quantity cannot be less than 0");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws IllegalArgumentException {
        this.quantity = quantity;
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }
    }

    public T getProduct() {
        return product;
    }

    public void setProduct(T product) throws IllegalArgumentException {
        this.product = product;
        if(product == null){
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }
    }

    @Override
    public String toString() {
        return "\nQuantity: " + quantity;
    }
}

import java.io.IOException;

public class VendRunner {
    public static void main(String[] args) throws IllegalArgumentException, IOException {

            Snack chips = new Snack(true, "Lays Chips", 3.50);
            Beverage soda = new Beverage(16.9, "Coke Cola", 4.99);
            Slot crisps = new Slot(5, chips);
            Slot drinks = new Slot(4, soda);
            VendingMachine v1 = new VendingMachine<>();

            v1.addProduct("412", crisps);
            v1.addProduct("321", drinks);
            v1.dispenseProduct("412");
            v1.dispenseProduct("321");
            System.out.println("There are " + crisps.getQuantity() + " remaining " + chips.getName());
            System.out.println("There are " + drinks.getQuantity() + " remaining " + soda.getName());
            System.out.println();
            v1.loadProductsFromCSV("./src/products.csv");
            v1.displayProducts();
            System.out.println();
            

            try {
                Snack exception1 = new Snack(false, null, -2.99);
            } catch (IllegalArgumentException e) {
                System.out.println("Snack object error: " + e.getMessage());
            }

            try{
                Beverage exception2 = new Beverage(-16.9, "Sprite", 4.99);
            } catch (IllegalArgumentException e) {
                System.out.println("Beverage object error: " + e.getMessage());
            }

            try {
                Slot exception3 = new Slot(-30, chips);
            } catch (IllegalArgumentException e){
                System.out.println("Slot object error: " + e.getMessage());
            }

            try {
                Slot exception4 = new Slot(5, null);
            } catch (IllegalArgumentException e){
                System.out.println("Slot object error: " + e.getMessage());
            }

            try {
                v1.addProduct(null, crisps);
            } catch(IllegalArgumentException | NullPointerException e) {
                System.out.println("Product object error: " + e.getMessage());
            }


    }
}
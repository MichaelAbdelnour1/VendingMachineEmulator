import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class VendingMachine <T extends Product>  {
    Map<String, Slot<? extends Product>> slots;

    public VendingMachine()  {
        slots = new HashMap<>();
    }

   public void addProduct(String code, Slot<? extends Product> slot) throws IllegalArgumentException{
        if(code == null || code.isEmpty() || slot == null){
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
       slots.put(code, slot);
   }

   public Product dispenseProduct(String code) throws IllegalArgumentException, IOException {
        if(code == null || code.isEmpty()){
            throw new IllegalArgumentException("Code cannot be null or empty");
        }

        Slot<? extends Product> foundSlot = slots.get(code);
       if (foundSlot != null && foundSlot.getQuantity() > 0) {
           foundSlot.setQuantity(foundSlot.getQuantity() - 1);

           if (foundSlot.getQuantity() == 0) {
               sendVendorNotification(foundSlot.getProduct());
           }

           System.out.println("Dispensing " + foundSlot.getProduct().getName() + " from slot " + code);
           printReceipt(foundSlot.getProduct());
           return foundSlot.getProduct();
       } else
       {
           return null;
       }
   }

    public void printReceipt (Product product) throws IOException {
        String fileName = "receipt.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Receipt - " + LocalDateTime.now());
            writer.newLine();
            writer.write("Item: " + product.getName());
            writer.newLine();
            writer.write("Amount: $" + product.getPrice());
            writer.newLine();
            writer.write("----------------------------");
            writer.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendVendorNotification(Product product) throws IOException {
        String fileName = "notification_" + product.getName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Notification - OUT OF STOCK");
            writer.newLine();
            writer.write("Timestamp :" + LocalDateTime.now());
            writer.newLine();
            writer.write("Item: " + product.getName());
            writer.newLine();
            writer.write("----------------------------");
            writer.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProductsFromCSV(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = reader.readLine()) != null){
                String[] tokens = line.split(",");
                if (tokens.length == 6)  {
                    String code = tokens[0];
                    String item = tokens[1];
                    String name = tokens[3];
                    double price = Double.parseDouble(tokens[4]);
                    int quantity = Integer.parseInt(tokens[5]);

                    Product prod;
                    if(item.equals("Snack")){
                        String tempVegan = tokens[2];
                        boolean isVegan = Boolean.parseBoolean(tempVegan);
                        prod = new Snack(isVegan, name, price);

                    } else{
                         String tempflOunces = tokens[2];
                         double flOunces = Double.parseDouble(tempflOunces);
                         prod = new Beverage(flOunces, name, price);
                    }

                    Slot<Product> slot = new Slot<>(quantity, prod);
                    slots.put(code, slot);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayProducts() {
       for (Map.Entry<String, Slot<? extends Product>> entry : slots.entrySet()) {
           System.out.println("Key: " + entry.getKey() + ": "  + entry.getValue().getProduct());
       }
   }
}

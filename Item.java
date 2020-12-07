import java.text.NumberFormat;

public class Item {

    // Variables specific to each item
    private String name;
    private double price;
    private int bulkQuantity;;
    private double bulkPrice;
    private boolean bool = false;

    public Item (String name, double price){
        // Constructor - throws exception if price is negative
        if (price < 0){
            throw new IllegalArgumentException();
        }

        // sets objects' variables equal to input
        this.name = name;
        this.price = price;
    }

    public Item (String name, double price, int bulkQuantity, double bulkPrice){
        // Constructor - throws exception if the price(s) are negative
        if (price < 0 || bulkQuantity < 0|| bulkPrice < 0){
            throw new IllegalArgumentException();
        }

        // sets objects' variables equal to input
        this.name = name;
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
        this.bool = true;
    }

    public double priceFor(int quantity){
        // throws exception if negative quantity is inputted
        if (quantity < 0){
            throw new IllegalArgumentException();
        }

        // checks if bulkquantity is set to a value - if so adjust price based off bulkprice if applicable
        if (bulkQuantity != 0) {
            int temp = (quantity / bulkQuantity);
            double totalPrice = temp * bulkPrice + ((quantity - (temp * bulkQuantity)) * price);
            return totalPrice;
        }
        // else it just returns the total price - quantity times price per one
        else{
            return quantity * this.price;
        }
    }

    public String toString(){
        // follows instructions to make sure that the returned quantity is of appropriate length with currency
       NumberFormat nf = NumberFormat.getCurrencyInstance();
       String str = this.name + ", " + nf.format(this.price);

       // If bulkquantity is a value, add the bulk price to the string that will be returned
       if (this.bool){
            str += " (The price of our bulk quantity of " + this.bulkQuantity + " is " + nf.format(this.bulkPrice) + ")";
       }
       return str;
    }

}

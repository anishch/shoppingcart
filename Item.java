public class Item {

    private String name;
    private double price;
    private int bulkQuantity;;
    private double bulkPrice;
    private boolean bool = false;

    public Item (String name, double price){
        if (price < 0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
    }

    public Item (String name, double price, int bulkQuantity, double bulkPrice){
        if (price < 0 || bulkQuantity < 0|| bulkPrice < 0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
        this.bool = true;
    }

    public double priceFor(int quantity){
        if (quantity < 0){
            throw new IllegalArgumentException();
        }
        int temp = (int) (quantity/bulkQuantity);
        double totalPrice = temp * bulkPrice + ((quantity - (temp * bulkQuantity)) * price);
        return totalPrice;
    }

    public String toString(){
       String str = this.name + ", " + this.price;
       if (this.bool){
            str += " (The price of our bulk quantity of " + this.bulkQuantity + " is " + this.bulkPrice + ")";
       }
       return str;
    }

}

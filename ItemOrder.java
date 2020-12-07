public class ItemOrder {

    // variables for each object of an ItemOrder
    private double price;
    private Item item;
    public int quantity = 0;

    // constructor - sets quantity to input if inputtedQuantity > 0, else
    // it is set to 0. Also calls Item's priceFor method to set price
    // variable to the desired amount based off quantity
    public ItemOrder(Item item, int quantity){
        this.item = item;
        if (!(quantity > 0)){
            this.quantity = quantity;
        }
        this.price = item.priceFor(quantity);
    }

    // get methods
    public double getPrice(){
        return this.price;
    }

    public Item getItem(){
        return this.item;
    }
}

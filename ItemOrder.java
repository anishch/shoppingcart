public class ItemOrder {

    private double price;
    private Item item;
    public int quantity;

    public ItemOrder(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
        this.price = item.priceFor(quantity);
    }

    public double getPrice(){
        return this.price;
    }

    public Item getItem(){
        return this.item;
    }
}

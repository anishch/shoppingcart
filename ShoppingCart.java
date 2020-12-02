import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<ItemOrder> list;
    double price = 0.0;


    public ShoppingCart(){
        this.list = new ArrayList<ItemOrder>();
    }

    public void add(ItemOrder itemorder){
        this.list.add(itemorder);
        price += itemorder.getPrice();
        clean(itemorder);
    }

    private void clean(ItemOrder whatweAreAdding){
        for (ItemOrder thingies : this.list){
            if (thingies.getItem().toString().equals(whatweAreAdding.getItem().toString())){
                list.add(new ItemOrder(thingies.getItem(), whatweAreAdding.quantity));
                list.remove(thingies);
            }
        }

    }

    public void setDiscount(boolean bool){
        price = (0.9 * price);
    }

    public double getTotal(){
        return this.price;
    }
}

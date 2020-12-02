import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<ItemOrder> list;
    private double price;
    private boolean firstTime;

    public ShoppingCart(){
        this.list = new ArrayList<ItemOrder>();
        this.price = 0.0;
        this.firstTime = true;
    }

    public void add(ItemOrder whatweAreAdding){
        boolean duplicate = false;
        for (ItemOrder thingies : this.list){
            if (thingies.getItem().toString().equals(whatweAreAdding.getItem().toString())){
                list.add(new ItemOrder(thingies.getItem(), whatweAreAdding.quantity));
                list.remove(thingies);
                duplicate = true;
            }
        }
        if (!duplicate){
            this.list.add(whatweAreAdding);
        }
        //
        if (firstTime == false){
            price += 0.9 * whatweAreAdding.getPrice();
        }
        else{
            price += whatweAreAdding.getPrice();
        }
    }

    public void setDiscount(boolean bool){
        if (bool && firstTime){
            bool = false;
            firstTime = false;
            price = 0.9 * price;
        }
        else if (bool && !firstTime){
            price = 1/0.9 * price;
            firstTime = true;
        }

    }

    public double getTotal(){
        return this.price;
    }
}

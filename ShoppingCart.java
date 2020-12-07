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
        int index = 0;
        double money = 0;
        for (ItemOrder thingies : this.list){
            if (thingies.getItem().toString().equals(whatweAreAdding.getItem().toString())){
                index = list.indexOf(thingies);
                duplicate = true;
                money = thingies.getPrice();
            }
        }
        if (duplicate){
            list.remove(index);
            if (firstTime){
                price -= money;
            }
            else{
                price -= 0.9 * money;
            }
        }
        this.list.add(whatweAreAdding);
        if (firstTime == false){
            price += 0.9 * whatweAreAdding.getPrice();
        }
        else{
            price += whatweAreAdding.getPrice();
        }
    }

    public void setDiscount(boolean bool){
        if (bool){
            //bool = false;
            firstTime = false;
            price = 0.9 * price;
        }
        else {
            price = 1/0.9 * price;
            firstTime = true;
        }

    }

    public double getTotal(){
        return this.price;
    }
}

import java.util.ArrayList;

public class ShoppingCart {

    // variables for a shopping cart
    private ArrayList<ItemOrder> list;
    private double price;
    private boolean firstTime;

    // Constructor sets up variables
    public ShoppingCart(){
        this.list = new ArrayList<ItemOrder>();
        this.price = 0.0;
        this.firstTime = true;
    }

    public void add(ItemOrder whatweAreAdding){
        boolean duplicate = false;
        int index = 0;
        double money = 0;
        for (ItemOrder thingies : this.list){ // iterates through ArrayList of ItemOrders
            if (thingies.getItem().toString().equals(whatweAreAdding.getItem().toString())){
                // if an ItemOrder of the same type (as in what is being ordered) is added,
                // then set up these variables
                index = list.indexOf(thingies);
                duplicate = true;
                money = thingies.getPrice();
            }
        }
        // when there is a duplicate of item type, then delete the previous item from list
        // and subtract their price which was added to toal
        if (duplicate){
            list.remove(index);
            if (firstTime){
                price -= money;
            }
            else{
                price -= 0.9 * money;
            }
        }

        // adds the item (for both duplicates, which were already removed, and all items)
        this.list.add(whatweAreAdding);

        if (firstTime == false){ // if we need to apply discount, then apply discount when adding to total price
            price += 0.9 * whatweAreAdding.getPrice();
        }
        else{ // else just add the price of added object without discount to total price
            price += whatweAreAdding.getPrice();
        }
    }

    public void setDiscount(boolean bool){
        if (bool){ // if we need to apply discount, set boolean to false and apply discount
            firstTime = false;
            price = 0.9 * price;
        }
        else {
            // else, 'un-apply' discount and set boolean to true
            price = 1/0.9 * price;
            firstTime = true;
        }

    }

    // get method
    public double getTotal(){
        return this.price;
    }
}

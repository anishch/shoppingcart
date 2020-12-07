import java.util.ArrayList;

public class Catalog {

    // simple class that creates an array list to store Item objects,
    // and the methods return the requested information about the list
    private String name;
    private ArrayList<Item> list = new ArrayList<Item>();

    public Catalog(String name){
        this.name = name;
    }

    public void add (Item item){
        list.add(item);
    }

    public int size(){
        return list.size();
    }

    public Item get(int index){
        return list.get(index);
    }

    public String getName(){
        return this.name;
    }
}

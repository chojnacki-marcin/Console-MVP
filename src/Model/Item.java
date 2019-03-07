package Model;

import DAL.Identifiable;

import java.io.Serializable;

public class Item implements Identifiable, Serializable {

    private long id;
    private String name;
    private long shoppingListId;

    public Item(){

    }

    public Item(String name, long shoppingListId) {
        this.name = name;
        this.shoppingListId = shoppingListId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(long shoppingListId) {
        this.shoppingListId = shoppingListId;
    }
}

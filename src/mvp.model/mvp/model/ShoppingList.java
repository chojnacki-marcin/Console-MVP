package mvp.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList implements Identifiable, Serializable {

    private long id;
    private String name;
    private String description;

    private List<Item> items = new ArrayList<>();

    public ShoppingList() {
    }

    public ShoppingList(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ShoppingList(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

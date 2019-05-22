package mvp.dao;


import mvp.model.ShoppingList;

public interface ShoppingListDAO extends GenericDAO<ShoppingList>{
    boolean exists(long id);
}

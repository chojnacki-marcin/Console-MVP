package DAL;

import Model.ShoppingList;

public interface ShoppingListDAO extends GenericDAO<ShoppingList>{
    boolean exists(long id);
}

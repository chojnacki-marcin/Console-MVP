package mvp.dao;


import mvp.model.Item;

import java.util.List;

public interface ItemDAO extends GenericDAO<Item> {

    List<Item> findAllByShoppingListId(long shoppingListId);

}

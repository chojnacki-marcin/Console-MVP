package mvp.presenter;



import mvp.dao.ItemDAO;
import mvp.model.Item;
import mvp.view.ItemView;

import java.util.Optional;

public class ItemPresenter {

    private final ItemDAO itemDAO;
    private ItemView itemView;

    public ItemPresenter(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public void addItem(String name, long shoppingListId){
        Item item = new Item(name, shoppingListId);
        if(!itemDAO.add(item)){
            itemView.displayCreateErrorMessage();
        }
    }

    public void modifyItem(long itemId, String name) {
        Optional<Item> itemOptional = itemDAO.findById(itemId);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            item.setName(name);
            itemDAO.update(item);
        } else {
            itemView.displayModifyErrorMessage();
        }
    }

    public void deleteItem(long id){
        if(!itemDAO.delete(id)){
            itemView.displayDeleteErrorMessage();
        }
    }

    public void setItemView(ItemView itemView) {
        this.itemView = itemView;
    }

    public void getItems(long shoppingListId) {
        var items = itemDAO.findAllByShoppingListId(shoppingListId);
        items.forEach(item -> itemView.displayItem(item.getId(), item.getName()));
    }
}

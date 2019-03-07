package DAL;

import Model.ShoppingList;

import java.util.List;
import java.util.Optional;

public class FileStorageShoppingListDAO extends AbstractFileStorageDAO<ShoppingList> implements ShoppingListDAO {

    private final ItemDAO itemDAO;

    public FileStorageShoppingListDAO(String storagePath, ItemDAO itemDAO){
        super(storagePath);
        this.itemDAO = itemDAO;
    }

    @Override
    public boolean exists(long id) {
        List<ShoppingList> shoppingLists = loadData();
        return shoppingLists.stream().anyMatch(s -> s.getId() == id);
    }

    @Override
    public boolean delete(long id){
        List<ShoppingList> lists = loadData();
        Optional<ShoppingList> oldShoppingList = findById(id, lists);
        if(oldShoppingList.isPresent()){
            lists.remove(oldShoppingList.get());
            itemDAO.findAllByShoppingListId(id).forEach(i -> itemDAO.delete(i.getId()));
            return saveData(lists);
        }
        else {
            return false;
        }
    }
}

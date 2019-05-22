package mvp.file_storage_dao;



import mvp.dao.ItemDAO;
import mvp.dao.ShoppingListDAO;
import mvp.model.ShoppingList;

import java.util.List;
import java.util.Optional;

public class FileStorageShoppingListDAO extends mvp.file_storage_dao.AbstractFileStorageDAO<ShoppingList> implements ShoppingListDAO {

    private static final String DEFAULT_STORAGE_PATH = "lists";
    private final ItemDAO itemDAO;

    public FileStorageShoppingListDAO(){
        super(DEFAULT_STORAGE_PATH);
        itemDAO = new mvp.file_storage_dao.FileStorageItemDAO();
    }

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

package mvp.file_storage_dao;


import mvp.dao.ItemDAO;
import mvp.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class FileStorageItemDAO extends mvp.file_storage_dao.AbstractFileStorageDAO<Item> implements ItemDAO {


    private static final String DEFAULT_STORAGE_PATH = "items";

    public FileStorageItemDAO(){
        super(DEFAULT_STORAGE_PATH);
    }

    public FileStorageItemDAO(String storagePath) {
        super(storagePath);
    }

    @Override
    public List<Item> findAllByShoppingListId(long shoppingListId) {
        var items = loadData();
        return items.stream().filter(item -> item.getShoppingListId() == shoppingListId).collect(Collectors.toList());
    }
}

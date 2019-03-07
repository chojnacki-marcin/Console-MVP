package DAL;

import Model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class FileStorageItemDAO extends AbstractFileStorageDAO<Item> implements ItemDAO {


    public FileStorageItemDAO(String storagePath) {
        super(storagePath);
    }

    @Override
    public List<Item> findAllByShoppingListId(long shoppingListId) {
        var items = loadData();
        return items.stream().filter(item -> item.getShoppingListId() == shoppingListId).collect(Collectors.toList());
    }
}

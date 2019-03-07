import DAL.FileStorageItemDAO;
import DAL.FileStorageShoppingListDAO;
import DAL.ItemDAO;
import DAL.ShoppingListDAO;
import Presenter.ItemPresenter;
import Presenter.ShoppingListPresenter;
import Views.ConsoleInterface;

public class Main {

    private static final String LIST_STORAGE_PATH = "lists";
    private static final String ITEM_STORAGE_PATH = "items";

    public static void main(String[] args){
        //create dependencies
        ItemDAO itemDAO = new FileStorageItemDAO(ITEM_STORAGE_PATH);
        ShoppingListDAO shoppingListDAO = new FileStorageShoppingListDAO(LIST_STORAGE_PATH, itemDAO);

        ShoppingListPresenter shoppingListPresenter = new ShoppingListPresenter(shoppingListDAO);
        ItemPresenter itemPresenter = new ItemPresenter(itemDAO);

        var consoleInterface = new ConsoleInterface(shoppingListPresenter, itemPresenter);
        consoleInterface.run();
    }

}

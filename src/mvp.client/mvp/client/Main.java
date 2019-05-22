package mvp.client;

import mvp.dao.ItemDAO;
import mvp.dao.ShoppingListDAO;
import mvp.presenter.ItemPresenter;
import mvp.presenter.ShoppingListPresenter;
import mvp.console_view.ConsoleInterface;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args){

        //create dependencies
        ItemDAO itemDAO = ServiceLoader.load(ItemDAO.class).findFirst().orElseThrow();
        ShoppingListDAO shoppingListDAO = ServiceLoader.load(ShoppingListDAO.class).findFirst().orElseThrow();

        ShoppingListPresenter shoppingListPresenter = new ShoppingListPresenter(shoppingListDAO);
        ItemPresenter itemPresenter = new ItemPresenter(itemDAO);

        var consoleInterface = new ConsoleInterface(shoppingListPresenter, itemPresenter);
        consoleInterface.run();
    }

}

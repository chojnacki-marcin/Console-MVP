package Views;

import Presenter.ItemPresenter;
import Presenter.ShoppingListPresenter;

public class ConsoleInterface {


    private final ConsoleItemView consoleItemView;
    private final ConsoleShoppingListView consoleShoppingListView;

    public ConsoleInterface(ShoppingListPresenter shoppingListPresenter, ItemPresenter itemPresenter) {
        consoleItemView = new ConsoleItemView(itemPresenter);
        consoleShoppingListView = new ConsoleShoppingListView(shoppingListPresenter);

        itemPresenter.setItemView(consoleItemView);
        shoppingListPresenter.setShoppingListView(consoleShoppingListView);

        consoleShoppingListView.setItemView(consoleItemView);
    }

    public void run(){
        consoleShoppingListView.run();
    }
}

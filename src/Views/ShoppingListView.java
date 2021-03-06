package Views;

import java.util.Map;

public interface ShoppingListView {

    void displayCreateErrorMessage();
    void displayModifyErrorMessage();
    void displayDeleteErrorMessage();
    void displayShoppingList(long id, String name, String description);

    void displayShoppingListNotFoundError();

    void openItemView(long shoppingListId);
}

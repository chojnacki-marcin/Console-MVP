package mvp.presenter;


import mvp.dao.ShoppingListDAO;
import mvp.model.ShoppingList;
import mvp.view.ShoppingListView;

public class ShoppingListPresenter {

    private final ShoppingListDAO shoppingListDAO;
    private ShoppingListView shoppingListView;

    public ShoppingListPresenter(ShoppingListDAO shoppingListDAO) {
        this.shoppingListDAO = shoppingListDAO;
    }

    public void createShoppingList(String name, String description){
        ShoppingList shoppingList = new ShoppingList(name, description);
        if(!shoppingListDAO.add(shoppingList)){
            shoppingListView.displayCreateErrorMessage();
        }
    }

    public void modifyShoppingList(long id, String name, String description){
        ShoppingList shoppingList = new ShoppingList(id, name, description);
        if(!shoppingListDAO.update(shoppingList)){
            shoppingListView.displayModifyErrorMessage();
        }
    }

    public void deleteShoppingList(long id){
        if(!shoppingListDAO.delete(id)){
            shoppingListView.displayDeleteErrorMessage();
        }
    }

    public void getAllShoppingLists(){
        var lists = shoppingListDAO.findAll();
        lists.forEach(s -> shoppingListView.displayShoppingList(s.getId(), s.getName(), s.getDescription()));
    }




    public void setShoppingListView(ShoppingListView shoppingListView) {
        this.shoppingListView = shoppingListView;
    }

    public void manageShoppingListContents(long shoppingListId) {
        if(shoppingListDAO.exists(shoppingListId)){
            shoppingListView.openItemView(shoppingListId);
        }
        else {
            shoppingListView.displayShoppingListNotFoundError();
        }
    }
}

module mvp.console_view {

    exports mvp.console_view;

    requires mvp.presenter;
    requires mvp.view;

    provides mvp.view.ItemView with mvp.console_view.ConsoleItemView;
    provides mvp.view.ShoppingListView with mvp.console_view.ConsoleShoppingListView;

}
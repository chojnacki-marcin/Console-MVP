module mvp.client {

    exports mvp.client;
    requires mvp.dao;

    uses mvp.dao.ItemDAO;
    uses mvp.dao.ShoppingListDAO;

    requires mvp.presenter;
    requires mvp.console_view;

}
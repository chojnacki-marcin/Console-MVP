module mvp.file_storage_dao {

    requires mvp.model;
    requires mvp.dao;

    provides mvp.dao.ItemDAO with mvp.file_storage_dao.FileStorageItemDAO;
    provides mvp.dao.ShoppingListDAO with mvp.file_storage_dao.FileStorageShoppingListDAO;


}
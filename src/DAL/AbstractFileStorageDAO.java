package DAL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract class AbstractFileStorageDAO<T extends Identifiable & Serializable> implements GenericDAO<T>{

    private final String storageFilePath;

    private long nextId;

    AbstractFileStorageDAO(String storageFilePath){
        this.storageFilePath = storageFilePath;
        initializeId();
    }




    @Override
    public boolean add(T t) {
        t.setId(nextId++);
        List<T> lists = loadData();
        lists.add(t);
        return saveData(lists);
    }

    @Override
    public boolean update(T t) {
        List<T> lists = loadData();
        Optional<T> oldShoppingList = findById(t.getId(), lists);
        if(oldShoppingList.isPresent()){
            lists.remove(oldShoppingList.get());
            lists.add(t);
            return saveData(lists);
        }
        else {
            return false;
        }

    }

    @Override
    public boolean delete(long id) {
        List<T> lists = loadData();
        Optional<T> oldShoppingList = findById(id, lists);
        if(oldShoppingList.isPresent()){
            lists.remove(oldShoppingList.get());
            return saveData(lists);
        }
        else {
            return false;
        }
    }

    @Override
    public Optional<T> findById(long id){
        List<T> lists = loadData();
        return findById(id, lists);
    }

    public Optional<T> findById(long id, List<T> lists) {
        return lists.stream().filter(shoppingList -> shoppingList.getId() == id).findAny();
    }

    @Override
    public List<T> findAll() {
        return loadData();
    }



    private void initializeId(){
        List<T> shoppingLists = loadData();
        nextId = shoppingLists.stream().mapToLong(T::getId).max().orElse(-1) + 1;
    }

    List<T> loadData(){
        try(var inputStream = new ObjectInputStream(new FileInputStream(storageFilePath))){

            var object = inputStream.readObject();
            if(object instanceof List){
                return (List<T>) object;
            }
            else {
                return new ArrayList<>();
            }

        }
        catch (IOException | ClassNotFoundException ex){
            return new ArrayList<>();
        }
    }

    boolean saveData(List<T> list){
        try(var outputStream = new ObjectOutputStream(new FileOutputStream(storageFilePath))){
            outputStream.writeObject(list);
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }
}

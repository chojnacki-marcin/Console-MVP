package mvp.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {

    boolean add(T t);

    boolean update(T t);

    boolean delete(long id);

    Optional<T> findById(long id);

    List<T> findAll();
}

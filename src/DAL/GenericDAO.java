package DAL;

import java.util.List;
import java.util.Optional;
import java.util.function.ToLongFunction;

public interface GenericDAO<T> {

    boolean add(T t);

    boolean update(T t);

    boolean delete(long id);

    Optional<T> findById(long id);

    List<T> findAll();
}

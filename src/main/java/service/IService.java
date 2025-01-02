package service;

import java.util.List;

public interface IService <T> {
    List<T> getAll();

    List<T> save(T t);

    void remove(int id);

    List<T> update(int id, T t);

    T findById(int id);

    List<T> findByName(String name);

}

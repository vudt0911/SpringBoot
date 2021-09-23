package vu.dinh.bookstore.repository;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    public List<T> getAll();

    public Optional<T> get(int id);

    public void add(T t);

    public void update(T t);

    public void deleteById(int id);
}

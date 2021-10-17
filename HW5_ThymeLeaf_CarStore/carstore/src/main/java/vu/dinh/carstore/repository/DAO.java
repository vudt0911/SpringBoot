package vu.dinh.carstore.repository;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    public List<T> getAll();

    public Optional<T> getById(int id);

    public void add(T t);

    public void update(T t);

    public void delete(int id);

    public List<T> sorf(long price);
}

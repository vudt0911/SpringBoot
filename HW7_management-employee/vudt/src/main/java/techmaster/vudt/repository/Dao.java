package techmaster.vudt.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Dao<T> {
    protected List<T> listEmployee = new ArrayList<>();

    public abstract void readCSV(String csvFile);

    public abstract List<T> getAll();

    public abstract Optional<T> get(int id);

    public abstract void add(T t);

    public abstract void update(T t);

    public abstract void deleteById(int id);

    public abstract List<T> searchByKeyword(String keyword);


}

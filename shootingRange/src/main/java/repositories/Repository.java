package repositories;

import java.util.HashSet;
import java.util.Set;

public class Repository<T> {

    protected Set<T> repository = new HashSet<>();

    public int size() {
        return repository.size();
    }

    public void add(T obj) {
        repository.add(obj);
    }

    public void remove(T obj) {
        repository.remove(obj);
    }

    public Set<T> findAll() {
        return repository;
    }

}

package jpa.knowledge.service;

public interface ApplicationService<T> {

    void create(T entity);
    T get(Integer id);
}

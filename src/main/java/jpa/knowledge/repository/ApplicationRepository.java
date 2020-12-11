package jpa.knowledge.repository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ApplicationRepository<T> {

    void create(T entity);
    T get(Integer id);
}

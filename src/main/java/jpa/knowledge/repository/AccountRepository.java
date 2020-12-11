package jpa.knowledge.repository;

import jpa.knowledge.entity.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository(value = "accountRepository")
public class AccountRepository implements ApplicationRepository<Account> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Account entity) {
        entityManager.persist(entity);
    }

    @Override
    public Account get(Integer id) {
        return entityManager.find(Account.class, id);
    }
}

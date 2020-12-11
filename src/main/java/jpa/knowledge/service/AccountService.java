package jpa.knowledge.service;

import jpa.knowledge.entity.Account;
import jpa.knowledge.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "accountService")
public class AccountService implements ApplicationService<Account> {

    private ApplicationRepository repository;

    @Autowired
    public AccountService(@Qualifier("accountRepository") ApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void create(Account entity) {
        repository.create(entity);
    }

    @Override
    public Account get(Integer id) {
        return null;
    }
}

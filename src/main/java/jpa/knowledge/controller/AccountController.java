package jpa.knowledge.controller;

import jpa.knowledge.entity.Account;
import jpa.knowledge.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "bank/accounts")
public class AccountController implements ApplicationController<Account> {

    private final ApplicationService service;

    @Autowired
    public AccountController(@Qualifier("accountService") ApplicationService service) {
        this.service = service;
    }

    @Override
    public void create(Account entity) {
        service.create(entity);
    }

    @Override
    public Account get(Integer id) {
        return null;
    }
}

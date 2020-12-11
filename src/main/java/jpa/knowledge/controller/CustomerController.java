package jpa.knowledge.controller;

import jpa.knowledge.entity.Customer;
import jpa.knowledge.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "bank/customers")
public class CustomerController implements ApplicationController<Customer> {

    private ApplicationService service;

    @Autowired
    public CustomerController(@Qualifier("customerService") ApplicationService service) {
        this.service = service;
    }

    @Override
    public void create(Customer entity) {

    }

    @Override
    public Customer get(Integer id) {
        return (Customer) service.get(id);
    }
}

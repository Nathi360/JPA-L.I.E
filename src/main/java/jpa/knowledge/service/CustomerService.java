package jpa.knowledge.service;

import jpa.knowledge.entity.Customer;
import jpa.knowledge.repository.ApplicationRepository;
import jpa.knowledge.utility.CustomerAccountPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "customerService")
public class CustomerService implements ApplicationService<Customer> {

    private ApplicationRepository repository;

    @Autowired
    public CustomerService(@Qualifier("customerRepository") ApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Customer entity) {

    }

    @Override
    public Customer get(Integer id) {
        Customer customer = (Customer) repository.get(id);
        CustomerAccountPrinter.printAccounts(customer);
        return customer;
    }
}

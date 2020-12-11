package jpa.knowledge.repository;

import jpa.knowledge.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository(value = "customerRepository")
public class CustomerRepository implements ApplicationRepository<Customer> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Customer entity) {

    }

    @Override
    public Customer get(Integer id) {

        Customer customer = entityManager.find(Customer.class, id);

        // Get new instance of EM (not container managed)
//        entityManager = DatabaseConnectionUtility.getEntityManagerFactory().createEntityManager();
//        entityManager.getTransaction().begin();
//        Customer customer2 = entityManager.find(Customer.class, id);
//        entityManager.getTransaction().commit();

        return customer;
    }
}

import jpa.knowledge.entity.Account;
import jpa.knowledge.entity.Customer;
import jpa.knowledge.utility.DatabaseConnectionUtility;
import org.hibernate.LazyInitializationException;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JpaTest {

    private static EntityManagerFactory factory;

    @BeforeClass
    public static void initialise() {
        factory = DatabaseConnectionUtility.getEntityManagerFactory();
    }

    @Test
    public void testGetAccountsWhileSessionIsOpen() {

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = entityManager.find(Customer.class, 1);
        entityManager.getTransaction().commit();
        System.out.println(customer.getAccounts());
        entityManager.close();
    }

    @Test(expected = LazyInitializationException.class)
    public void testReproduceLazyInitializationException() {

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = entityManager.find(Customer.class, 1);
        customer.abc();
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Accounts: " + customer.getAccounts().size());
    }

    @Test
    public void testGetCustomerAccountsAfterSessionClosure(){
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = entityManager.find(Customer.class, 1);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Accounts: " + customer.getAccounts());
    }

    @Test(expected = NullPointerException.class)
    public void testCascadingDeletes() {

        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Customer customer = entityManager.find(Customer.class, 1);
        entityManager.remove(customer);

        Account acc = entityManager.find(Account.class, 2);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Created: " + acc.getCreationDate());
    }
}

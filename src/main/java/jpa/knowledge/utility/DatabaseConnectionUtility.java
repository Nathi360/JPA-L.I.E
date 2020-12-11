package jpa.knowledge.utility;

import jpa.knowledge.entity.Account;
import jpa.knowledge.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Objects;
import java.util.Properties;

public class DatabaseConnectionUtility {

    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (Objects.isNull(factory)) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/BANK");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "postgrespass");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Account.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                                .applySettings(configuration.getProperties()).build();
                factory = configuration.buildSessionFactory(serviceRegistry).openSession().getEntityManagerFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return factory;
    }
}

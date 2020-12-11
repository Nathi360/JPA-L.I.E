package jpa.knowledge.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerid")
    private Set<Account> accounts = new HashSet<>();


    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Account> getAccounts() {
        System.out.println("Class-name: " + accounts.getClass().getName());
        return accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts.addAll(accounts);
    }

    public void abc() {
        System.out.println("Class-name-abc: " + accounts.getClass().getName());
    }
}

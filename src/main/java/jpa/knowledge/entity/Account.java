package jpa.knowledge.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "creationdate")
    private Date creationDate;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "customerid")
    private int customerId;


    public Account() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "creationDate=" + creationDate +
                ", balance=" + balance +
                ", customerId=" + customerId +
                '}';
    }
}

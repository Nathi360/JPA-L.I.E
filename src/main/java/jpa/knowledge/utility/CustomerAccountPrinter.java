package jpa.knowledge.utility;

import jpa.knowledge.entity.Customer;

public class CustomerAccountPrinter {

    public static void printAccounts(Customer customer){
        System.out.println(customer.getName() + " " + customer.getSurname());
        System.out.println(customer.getAccounts());
    }
}

package org.suhas.emusicstore.service;

import org.suhas.emusicstore.model.Customer;

import java.util.List;

/**
 * Created by suhas on 5/27/2016.
 */
public interface CustomerService {

    public void addCustomer(Customer customer);

    public Customer getCustomerById(int customerId);

    public List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
}

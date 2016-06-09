package org.suhas.emusicstore.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.suhas.emusicstore.dao.CustomerDao;
import org.suhas.emusicstore.model.Authorities;
import org.suhas.emusicstore.model.Cart;
import org.suhas.emusicstore.model.Customer;
import org.suhas.emusicstore.model.Users;

import java.util.List;

/**
 * Created by suhas on 5/27/2016.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);


        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);
        session.flush();

    }

    public Customer getCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class,customerId);
    }

    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customers = query.list();
        return customers;
    }

    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setString(0,username);

        return (Customer) query.uniqueResult();
    }
}

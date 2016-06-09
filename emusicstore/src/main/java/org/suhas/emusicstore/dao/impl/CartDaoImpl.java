package org.suhas.emusicstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.suhas.emusicstore.dao.CartDao;
import org.suhas.emusicstore.model.Cart;

/**
 * Created by suhas on 5/28/2016.
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao {
    @Autowired
    SessionFactory sessionFactory;

    public Cart getCartById(int cartId) {
       Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class,cartId);
    }

    public void updateCart(Cart cart) {
        // to do
    }
}

package org.suhas.emusicstore.dao;

import org.suhas.emusicstore.model.Cart;

/**
 * Created by suhas on 5/18/2016.
 */
public interface CartDao {

    Cart getCartById(int cartId);

    void updateCart(Cart cart);
}

package org.suhas.emusicstore.service;

import org.suhas.emusicstore.model.Cart;

/**
 * Created by suhas on 5/28/2016.
 */
public interface CartService {

    Cart getCartById(int cartId);

    void updateCart(Cart cart);
}

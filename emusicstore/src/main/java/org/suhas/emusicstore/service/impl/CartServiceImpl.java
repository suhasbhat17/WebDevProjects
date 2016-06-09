package org.suhas.emusicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suhas.emusicstore.dao.CartDao;
import org.suhas.emusicstore.model.Cart;
import org.suhas.emusicstore.service.CartService;

/**
 * Created by suhas on 5/28/2016.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }
}

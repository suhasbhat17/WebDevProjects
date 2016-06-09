package org.suhas.emusicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suhas.emusicstore.dao.CartItemDao;
import org.suhas.emusicstore.model.Cart;
import org.suhas.emusicstore.model.CartItem;
import org.suhas.emusicstore.service.CartItemService;

/**
 * Created by suhas on 5/28/2016.
 */
@Service
public class CartItemServiceImpl implements CartItemService {


    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {

        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {

        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart) {

        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemById(int productId) {
        return cartItemDao.getCartItemById(productId);
    }
}

package org.suhas.emusicstore.dao;

import org.suhas.emusicstore.model.Cart;
import org.suhas.emusicstore.model.CartItem;

/**
 * Created by suhas on 5/28/2016.
 */
public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemById(int productId);
}

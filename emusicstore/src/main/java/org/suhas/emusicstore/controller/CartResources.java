package org.suhas.emusicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.suhas.emusicstore.model.Cart;
import org.suhas.emusicstore.model.CartItem;
import org.suhas.emusicstore.model.Customer;
import org.suhas.emusicstore.model.Product;
import org.suhas.emusicstore.service.CartItemService;
import org.suhas.emusicstore.service.CartService;
import org.suhas.emusicstore.service.CustomerService;
import org.suhas.emusicstore.service.ProductService;

import java.util.List;


/**
 * Created by suhas on 5/28/2016.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/{cartId}")
    public
    @ResponseBody
    Cart getCartById(@PathVariable("cartId") int cartId) {

        return cartService.getCartById(cartId);

    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        for (int i=0; i < cartItems.size(); i++){
            if(product.getProductId() == cartItems.get(i).getProduct().getProductId()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }


    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId") int productId){
        CartItem cartItem = cartItemService.getCartItemById(productId);
        cartItemService.removeCartItem(cartItem);

    }

    /*@RequestMapping(value = "/remove/{productId}", method = RequestMethod.GET)
    public String redirect(@PathVariable(value = "productId") int productId){
        return "redirect:/remove/"+ productId;
    }*/


    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable("cartId") int cartId){
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Please check your payload")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Server error")
    public void handleServerErrors(Exception e){}



}

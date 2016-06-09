package org.suhas.emusicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.suhas.emusicstore.model.Customer;
import org.suhas.emusicstore.service.CustomerService;

/**
 * Created by suhas on 5/28/2016.
 */
@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    CustomerService customerService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){

        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        int cartId = customer.getCart().getCartId();
        System.out.print(cartId);
        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable("cartId") int cartId, Model model){
        model.addAttribute("cartId",cartId);
        return "cart";
    }

}

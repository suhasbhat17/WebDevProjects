package org.suhas.emusicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.suhas.emusicstore.model.BillingAddress;
import org.suhas.emusicstore.model.Customer;
import org.suhas.emusicstore.model.ShippingAddress;
import org.suhas.emusicstore.service.CustomerService;

/**
 * Created by suhas on 5/26/2016.
 */
@Controller
public class RegisterCustomer {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/register")
    public String register(Model model){
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();

        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer",customer);

        return "registerCustomer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute("customer") Customer customer){
        customerService.addCustomer(customer);
        return "registerCustomerSuccess";
    }
}

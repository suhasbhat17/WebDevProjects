package org.suhas.emusicstore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.suhas.emusicstore.model.Product;
import org.suhas.emusicstore.service.ProductService;

import java.util.List;

/**
 * Created by suhas on 5/25/2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;
    @RequestMapping
    public String adminHome(){
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model){
       List<Product> products =  productService.getProductList();
        model.addAttribute("products",products);
        return "productinventory";
    }
}

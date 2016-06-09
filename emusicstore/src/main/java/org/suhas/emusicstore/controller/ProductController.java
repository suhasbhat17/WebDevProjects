package org.suhas.emusicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.suhas.emusicstore.model.Product;
import org.suhas.emusicstore.service.ProductService;

import java.util.List;

/**
 * Created by suhas on 5/25/2016.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/viewproduct/{id}")
    public String viewProduct(@PathVariable("id") int id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);

        return "viewProduct";
    }
}

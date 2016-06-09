package org.suhas.emusicstore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.suhas.emusicstore.model.Product;
import org.suhas.emusicstore.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by suhas on 5/25/2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminProduct {

    @Autowired
    private ProductService productService;

    private Path path;

    @RequestMapping("/product/addproduct")
    private String addProduct(Model model){
        Product product = new Product();
        product.setProductStatus("active");
        product.setProductCategory("wind");
        product.setProductCondition("new");
        model.addAttribute("product",product);

        return "addproduct";
    }

    @RequestMapping(value = "/product/addproduct", method = RequestMethod.POST)
    private String addProduct(@Valid @ModelAttribute Product product, BindingResult result, HttpServletRequest request){

        if(result.hasErrors()){
            return "addproduct";
        }

        productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDir + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if(productImage != null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image cannot be saved");
            }
        }
        return "redirect:/admin/productInventory";
    }


    @RequestMapping("/product/editproduct/{id}")
    private String editProduct(@PathVariable("id") int id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);

        return "editproduct";
    }

    @RequestMapping(value = "/product/editproduct", method = RequestMethod.POST)
    private String editProduct(@Valid @ModelAttribute Product product, BindingResult result, HttpServletRequest request){

        if(result.hasErrors()){
            return "editproduct";
        }



        MultipartFile productImage = product.getProductImage();
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDir + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if(productImage != null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image cannot be saved");
            }
        }

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id, HttpServletRequest request){
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDir + "\\WEB-INF\\resources\\images\\" + id + ".png");

        if(Files.exists(path)){
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productService.getProductById(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }
}

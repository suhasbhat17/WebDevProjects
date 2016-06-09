package org.suhas.emusicstore.service;

import org.suhas.emusicstore.model.Product;

import java.util.List;

/**
 * Created by suhas on 5/25/2016.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int productId);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);


}

package org.suhas.emusicstore.dao;

import org.suhas.emusicstore.model.Product;

import java.util.List;

/**
 * Created by suhas on 5/5/2016.
 */
public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(int productId);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

}

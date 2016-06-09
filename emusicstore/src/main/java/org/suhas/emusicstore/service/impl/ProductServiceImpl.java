package org.suhas.emusicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suhas.emusicstore.dao.ProductDao;
import org.suhas.emusicstore.model.Product;
import org.suhas.emusicstore.service.ProductService;

import java.util.List;

/**
 * Created by suhas on 5/25/2016.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
}

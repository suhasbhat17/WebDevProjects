package org.suhas.emusicstore.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.suhas.emusicstore.dao.ProductDao;
import org.suhas.emusicstore.model.Product;

import java.util.List;

/**
 * Created by suhas on 5/5/2016.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getProductList(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();
        return products;
    }

    public Product getProductById(int productId){
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class,productId);
        session.flush();
        return product;
    }

    public void addProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    public void editProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    public void deleteProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
    }
}

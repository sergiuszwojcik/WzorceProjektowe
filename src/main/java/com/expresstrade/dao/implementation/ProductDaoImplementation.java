package com.expresstrade.dao.implementation;

import com.expresstrade.dao.ProductDao;
import com.expresstrade.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//kontenery dla springa do bazy danych
@Repository
@Transactional // spring will now how to deal with this transactions
public class ProductDaoImplementation implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();   //Singleton pattern used session factory
        session.saveOrUpdate(product);
        session.flush(); //session operations executed
    }

    public Product getProductById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id); //hiberante search for this class for id prim key
        //then return the object type so we have to cast it into (Product).
        return product;

    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product"); //qurey return all product from product table
        List<Product> products = query.list();
        session.flush();

        return products;
    }


    public void deleteProduct(long id){
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();
    }

    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();   //Singleton pattern used session factory
        session.saveOrUpdate(product);
        session.flush(); //session operations executed
    }

}

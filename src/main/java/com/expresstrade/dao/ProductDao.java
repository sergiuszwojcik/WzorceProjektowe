package com.expresstrade.dao;


import com.expresstrade.model.Product;

import java.util.List;

public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(long id);

    List<Product> getAllProducts();

    void deleteProduct(long id);

    void updateProduct(Product product);

}





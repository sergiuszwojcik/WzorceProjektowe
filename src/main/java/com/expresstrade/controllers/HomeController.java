package com.expresstrade.controllers;

import com.expresstrade.dao.ProductDao;
import com.expresstrade.model.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String hello() {
        return "home";

    }

    //Lista produktow
    @RequestMapping("/productList")
    public String getProducts(Model model) { //import model parameter attached to view automatticaly whenever return
        //product list
        List<Product> products = productDao.getAllProducts();
        //Product product = productList.get(0); //make product instance reference to productList
        model.addAttribute("products", products); //bind product to the model object what we created
        //model will be attached to the view automatically
        return "productList"; //return productList as string

    }

    @RequestMapping("/productList/productDetail/{productId}") //{productId} path variable byle jaki string tu wchodzi
    //Pathvariable pobiera ten string ktory pobral sie w linku
    public String getProductDetail(@PathVariable long productId, Model model) throws IOException {
        //Dao data accesing object to get this object by id what we get from @pathvariable
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);

        return "productDetail";
    }



}

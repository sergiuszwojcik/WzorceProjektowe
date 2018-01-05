package com.expresstrade.controllers;

import com.expresstrade.dao.ProductDao;
import com.expresstrade.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminController {

    private Path path;

    @Autowired
    ProductDao productDao;

    @RequestMapping("/admin")
    public String adminPage() {

        return "admin";


    }

    @RequestMapping("/admin/productChange")
    public String productDetail(Model model) {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);

        return "productChange";

    }

    //By default when we nod declare the method in spring it is set to GET
    @RequestMapping("/admin/productChange/addProduct")
    public String addProduct(Model model) {

        Product product = new Product();
        product.setCategory("game");
        product.setCategory("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);

        return "addProduct";

    }

    //POST method action
    @RequestMapping(value = "/admin/productChange/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request) {

        if (result.hasErrors()) {
            return "addProduct";
        }

        productDao.addProduct(product);
        //product model get prodductimage
        MultipartFile productImage = product.getProductImage();
        //Get http session from real dynamic path
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String productId = Long.toString(product.getProductId());
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + productId + ".png");
        //System.out.println(path);

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failes", e);

            }
        }

        return "redirect:/admin/productChange";
    }

    @RequestMapping("/admin/productChange/deleteProduct/{productId}")

    public String deleteProduct(@PathVariable long productId, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String strProductId = Long.toString(productId);
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + strProductId + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        productDao.deleteProduct(productId);


        return "redirect:/admin/productChange";
    }


    @RequestMapping("/admin/productChange/updateProduct/{productId}")
    public String updateProduct(@PathVariable("productId") long productId, Model model) {

        Product product = productDao.getProductById(productId);
        model.addAttribute(product);

        return "updateProduct";

    }

    @RequestMapping(value = "/admin/productChange/updateProduct", method = RequestMethod.POST)
    public String updateProduct(@Valid @ModelAttribute("product") Product product, Model model, BindingResult result,
                                HttpServletRequest reuqest) {

        if (result.hasErrors()) {
            return "updateProduct";
        }

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = reuqest.getSession().getServletContext().getRealPath("/");
        String strProductId = Long.toString(product.getProductId());
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + strProductId + ".png");

        if (productImage != null && !productImage.isEmpty()) {

            try {
                productImage.transferTo(new File(path.toString()));

            } catch (Exception e) {
                throw new RuntimeException("Product image saving failed!", e);
            }

        }
        productDao.updateProduct(product);

        return "redirect:/admin/productChange";
    }
}

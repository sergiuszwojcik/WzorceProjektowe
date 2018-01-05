package com.expresstrade.controllers;


import com.expresstrade.dao.CartDao;
import com.expresstrade.dao.ProductDao;
import com.expresstrade.model.Cart;
import com.expresstrade.model.CartItem;
import com.expresstrade.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rest/cart") //rest service
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;
    //Returns json format object
    //DTO - data transfer object return Cart object which is in list of Cartlist
    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody
    //ResponseBody is for returning model object in format of JSON
    Cart read(@PathVariable(value = "cartId") String cartId) { //spring if see @ResponseBody object automatically pass
        //cut off object into json format and send in response body

        return cartDao.read(cartId);

    }


    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    //@RequestBody take the body of the request and transfer it into cart object its becouse we got json depedency
    //when spring see RequestBody will automatically transform json into cart object
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {

        cartDao.update(cartId, cart);

    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT) //no replying any content
    public void delete(@PathVariable(value = "cartId") String cartId) {

        cartDao.delete(cartId);

    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") long productId, HttpServletRequest request) {
        System.out.println("dupa");
        String sessionId = request.getSession(true).getId();
        System.out.println(sessionId);
        Cart cart = cartDao.read(sessionId);

        if (cart == null) {
            cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);

        if (product == null) {
            throw new IllegalArgumentException(new Exception());
        }

        cart.addCartItem(new CartItem(product));

        cartDao.update(sessionId, cart);

    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable long productId, HttpServletRequest request){

        String sessionId = request.getSession(true).getId();
        Cart cart = cartDao.read(sessionId);

        if (cart == null) {
            cart = cartDao.create(new Cart(sessionId));
        }

        Product product = productDao.getProductById(productId);

        if (product == null) {
            throw new IllegalArgumentException(new Exception());
        }

        cart.removeCartItem(new CartItem(product));

        cartDao.update(sessionId, cart);


    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handlerClientError(Exception e){

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerError(Exception e){

    }

}

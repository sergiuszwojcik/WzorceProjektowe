package com.expresstrade.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")       //Difference Mapping at class lvl is that it will be used in all functions(every start
public class CartItemController { // "/cart/+  url

    @RequestMapping //will be url "/cart"
    public String get(HttpServletRequest request) {
        return "redirect:/cart/" + request.getSession(true).getId(); //return cart path + session id
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public String getCart(@PathVariable(value = "cartId") String cartId, Model model){

        model.addAttribute("cartId", cartId);

        return "cart";

    }


}

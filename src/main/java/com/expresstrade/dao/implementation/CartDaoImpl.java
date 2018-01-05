package com.expresstrade.dao.implementation;

import com.expresstrade.dao.CartDao;
import com.expresstrade.model.Cart;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
//register class as a bean

@Repository
public class CartDaoImpl implements CartDao{

    private Map<String, Cart> listOfCarts;

    public CartDaoImpl() {
        listOfCarts = new HashMap<String, Cart>();

    }

    public Cart create(Cart cart) {

        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Cannot create a cart. Cart with given id(%) " + "" +
                    "already " + "exist ", cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);

        return cart;

    }

    public Cart read(String cartId) {

        return listOfCarts.get(cartId);

    }

    public void update(String cartId, Cart cart) {

        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Cannot update a cart. Cart with given id(%) " + "" +
                    "doesn't " + "exist ", cart.getCartId()));
        }

        listOfCarts.put(cartId, cart);

    }

    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Cannot delete a cart. Cart with given id(%) " + "" +
                    "doesn't " + "exist ", cartId));
        }

        listOfCarts.remove(cartId);

    }


}

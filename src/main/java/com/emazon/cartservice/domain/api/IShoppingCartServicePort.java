package com.emazon.cartservice.domain.api;

import com.emazon.cartservice.domain.model.ShoppingCart;

public interface IShoppingCartServicePort {
    ShoppingCart addItemToShoppingCart(ShoppingCart shoppingCart);
    String getLastUpdatedDateCartByUserId(Long userId);
}

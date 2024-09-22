package com.emazon.cartservice.domain.spi;

import com.emazon.cartservice.domain.model.ShoppingCart;

import java.util.List;

public interface IShoppingCartPersistencePort {
    ShoppingCart addItemToShoppingCart(ShoppingCart shoppingCart);
    ShoppingCart getArticleByUserIdAndArticleId(Long articleId, Long userId);
    List<Long> getArticlesByUserId(Long userId);
    String getLastUpdatedDateCartByUserId(Long userId);
}

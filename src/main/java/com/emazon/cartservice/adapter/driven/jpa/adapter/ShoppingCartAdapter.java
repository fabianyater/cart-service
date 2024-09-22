package com.emazon.cartservice.adapter.driven.jpa.adapter;

import com.emazon.cartservice.adapter.driven.jpa.entity.ShoppingCartEntity;
import com.emazon.cartservice.adapter.driven.jpa.mapper.IShoppingCartEntityMapper;
import com.emazon.cartservice.adapter.driven.jpa.repository.IShoppingCartRepository;
import com.emazon.cartservice.domain.model.ShoppingCart;
import com.emazon.cartservice.domain.spi.IShoppingCartPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShoppingCartAdapter implements IShoppingCartPersistencePort {
    private final IShoppingCartRepository shoppingCartRepository;
    private final IShoppingCartEntityMapper shoppingCartMapper;

    @Override
    public ShoppingCart addItemToShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCartMapper.toEntity(shoppingCart));

        return shoppingCart;
    }

    @Override
    public ShoppingCart getArticleByUserIdAndArticleId(Long articleId, Long userId) {
        return shoppingCartRepository.findByArticleIdAndUserId(articleId, userId)
                .map(shoppingCartMapper::toShoppingCart)
                .orElse(null);
    }

    @Override
    public List<Long> getArticlesByUserId(Long userId) {
        return shoppingCartRepository.findByUserId(userId).stream()
                .map(ShoppingCartEntity::getArticleId)
                .toList();
    }

    @Override
    public String getLastUpdatedDateCartByUserId(Long userId) {
        return shoppingCartRepository.findCartLastUpdatedDateByUserId(userId).toString();
    }
}

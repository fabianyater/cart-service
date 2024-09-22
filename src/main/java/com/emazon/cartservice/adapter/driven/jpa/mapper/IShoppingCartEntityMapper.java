package com.emazon.cartservice.adapter.driven.jpa.mapper;

import com.emazon.cartservice.adapter.driven.jpa.entity.ShoppingCartEntity;
import com.emazon.cartservice.domain.model.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IShoppingCartEntityMapper {
    ShoppingCartEntity toEntity(ShoppingCart shoppingCart);
    ShoppingCart toShoppingCart(ShoppingCartEntity shoppingCart);
}

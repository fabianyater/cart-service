package com.emazon.cartservice.adapter.driving.http.mapper;

import com.emazon.cartservice.adapter.driving.http.dto.response.ShoppingCartResponse;
import com.emazon.cartservice.domain.model.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IShoppingCartResponseMapper {
    ShoppingCartResponse toShoppingCartResponse(ShoppingCart shoppingCart);
}

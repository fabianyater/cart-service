package com.emazon.cartservice.adapter.driving.http.controller;

import com.emazon.cartservice.adapter.driving.http.dto.request.ShoppingCartRequest;
import com.emazon.cartservice.adapter.driving.http.dto.response.ShoppingCartResponse;
import com.emazon.cartservice.adapter.driving.http.mapper.IShoppingCartRequestMapper;
import com.emazon.cartservice.adapter.driving.http.mapper.IShoppingCartResponseMapper;
import com.emazon.cartservice.adapter.driving.http.util.RoleConstants;
import com.emazon.cartservice.adapter.driving.http.util.ShoppingCartApiPathsConstants;
import com.emazon.cartservice.domain.api.IShoppingCartServicePort;
import com.emazon.cartservice.domain.model.ShoppingCart;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ShoppingCartApiPathsConstants.BASE_SHOPPING_CART_URL)
@RequiredArgsConstructor
public class CartController {
    private final IShoppingCartServicePort shoppingCartServicePort;
    private final IShoppingCartRequestMapper shoppingCartRequestMapper;
    private final IShoppingCartResponseMapper shoppingCartResponseMapper;

    @PostMapping(ShoppingCartApiPathsConstants.ADD_TO_CART)
    @PreAuthorize(RoleConstants.HAS_ROLE_CUSTOMER)
    public ResponseEntity<ShoppingCartResponse> addToCart(@Valid @RequestBody ShoppingCartRequest request) {
        ShoppingCart shoppingCart = shoppingCartServicePort.addItemToShoppingCart(shoppingCartRequestMapper.toShoppingCart(request));
        ShoppingCartResponse response = shoppingCartResponseMapper.toShoppingCartResponse(shoppingCart);
        String lastUpdateDateAt = shoppingCartServicePort.getLastUpdatedDateCartByUserId(shoppingCart.getUserId());

        response.setLastUpdateDatedAt(lastUpdateDateAt);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String deleteCart() {
        return "delete cart";
    }

    @PostMapping("/shop")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String shopCart() {
        return "shop cart";
    }
}

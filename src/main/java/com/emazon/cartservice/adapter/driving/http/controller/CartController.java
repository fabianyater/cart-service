package com.emazon.cartservice.adapter.driving.http.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    @PostMapping("/")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String addToCart() {
        return "add to cart";
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

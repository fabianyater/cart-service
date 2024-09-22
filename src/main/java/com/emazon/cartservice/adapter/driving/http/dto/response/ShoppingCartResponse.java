package com.emazon.cartservice.adapter.driving.http.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartResponse {
    private Long userId;
    private Long articleId;
    private Integer quantity;
    private String createdAt;
    private String lastUpdateDatedAt;
}

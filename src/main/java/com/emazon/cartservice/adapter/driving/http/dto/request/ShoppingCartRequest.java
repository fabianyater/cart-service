package com.emazon.cartservice.adapter.driving.http.dto.request;

import com.emazon.cartservice.domain.util.DomainConstants;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartRequest {
    @NotNull(message = DomainConstants.ARTICLE_ID_REQUIRED)
    @Min(value = DomainConstants.MIN_ARTICLE_ID_VALUE, message = DomainConstants.MIN_ARTICLE_ID_VALUE_REQUIRED)
    private Long articleId;

    @NotNull(message = DomainConstants.QUANTITY_ID_REQUIRED)
    @Min(value = DomainConstants.MIN_QUANTITY_VALUE, message = DomainConstants.MIN_QUANTITY_VALUE_REQUIRED)
    private Integer quantity;
}

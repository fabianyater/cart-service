package com.emazon.cartservice.domain.spi;

import java.util.List;

public interface IStockPersistencePort {
    boolean existsById(Long id);
    boolean isStockAvailable(Long articleId, Integer requestedQuantity);
    List<String> getCategoryNamesByArticleId(Long articleId);
}

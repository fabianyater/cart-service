package com.emazon.cartservice.adapter.driven.feign.adapter;

import com.emazon.cartservice.adapter.driven.feign.client.IStockFeignClient;
import com.emazon.cartservice.adapter.driven.feign.dto.CategoryNameResponse;
import com.emazon.cartservice.domain.spi.IStockPersistencePort;
import feign.FeignException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StockAdapter implements IStockPersistencePort {
    private final IStockFeignClient stockFeignClient;

    @Override
    public boolean existsById(Long id) {
        try {
            return stockFeignClient.existsById(id);
        } catch (FeignException.NotFound e) {
            return false;
        }
    }

    @Override
    public boolean isStockAvailable(Long articleId, Integer requestedQuantity) {
        try {
            return stockFeignClient.isStockAvailable(articleId, requestedQuantity);
        } catch (FeignException.NotFound e) {
            return false;
        }
    }

    @Override
    public List<String> getCategoryNamesByArticleId(Long articleId) {
        try {
            return stockFeignClient.getCategoriesNameByArticleId(articleId).stream()
                    .map(CategoryNameResponse::getName)
                    .toList();
        } catch (FeignException.NotFound e) {
            return List.of();
        }
    }
}

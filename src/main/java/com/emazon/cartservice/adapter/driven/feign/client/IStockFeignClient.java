package com.emazon.cartservice.adapter.driven.feign.client;

import com.emazon.cartservice.adapter.driven.feign.dto.CategoryNameResponse;
import com.emazon.cartservice.adapter.driven.feign.util.StockFeignClientApiPathConstants;
import com.emazon.cartservice.adapter.driven.feign.util.StockFeignClientConstants;
import com.emazon.cartservice.configuration.feign.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = StockFeignClientConstants.STOCK_SERVICE_NAME,
        url = "${stock.service.url}",
        configuration = FeignInterceptor.class)
public interface IStockFeignClient {

    @GetMapping(value = StockFeignClientApiPathConstants.EXISTS_BY_ID)
    boolean existsById(@PathVariable Long articleId);

    @GetMapping(value = StockFeignClientApiPathConstants.AVAILABLE_STOCK)
    boolean isStockAvailable(
            @PathVariable(StockFeignClientApiPathConstants.ARTICLE_ID_REQUEST_PARAM) Long articleId,
            @RequestParam(StockFeignClientApiPathConstants.QUANTITY_REQUEST_PARAM) Integer quantity);

    @GetMapping(value = StockFeignClientApiPathConstants.GET_CATEGORIES_NAME)
    List<CategoryNameResponse> getCategoriesNameByArticleId(
            @PathVariable(StockFeignClientApiPathConstants.ARTICLE_ID_REQUEST_PARAM) Long articleId);
}

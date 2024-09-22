package com.emazon.cartservice.adapter.driven.feign.client;

import com.emazon.cartservice.adapter.driven.feign.dto.CategoryNameResponse;
import com.emazon.cartservice.adapter.driven.feign.util.FeignClientApiPathConstants;
import com.emazon.cartservice.adapter.driven.feign.util.FeignClientConstants;
import com.emazon.cartservice.configuration.feign.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = FeignClientConstants.STOCK_SERVICE_NAME,
        url = "${stock.service.url}",
        configuration = FeignInterceptor.class)
public interface IStockFeignClient {

    @GetMapping(value = FeignClientApiPathConstants.EXISTS_BY_ID)
    boolean existsById(@PathVariable Long articleId);

    @GetMapping(value = FeignClientApiPathConstants.AVAILABLE_STOCK)
    boolean isStockAvailable(
            @PathVariable(FeignClientApiPathConstants.ARTICLE_ID_REQUEST_PARAM) Long articleId,
            @RequestParam(FeignClientApiPathConstants.QUANTITY_REQUEST_PARAM) Integer quantity);

    @GetMapping(value = FeignClientApiPathConstants.GET_CATEGORIES_NAME)
    List<CategoryNameResponse> getCategoriesNameByArticleId(
            @PathVariable(FeignClientApiPathConstants.ARTICLE_ID_REQUEST_PARAM) Long articleId);
}

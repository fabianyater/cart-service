package com.emazon.cartservice.adapter.driven.feign.client;

import com.emazon.cartservice.adapter.driven.feign.dto.NextSupplyDateResponse;
import com.emazon.cartservice.adapter.driven.feign.util.FeignClientApiPathConstants;
import com.emazon.cartservice.adapter.driven.feign.util.FeignClientConstants;
import com.emazon.cartservice.configuration.feign.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = FeignClientConstants.SUPPLY_SERVICE_NAME,
        url = "${supply.service.url}",
        configuration = FeignInterceptor.class)
public interface ISupplyFeignClient {

    @GetMapping(value = FeignClientApiPathConstants.NEXT_SUPPLY_DATE)
    NextSupplyDateResponse getNextSupplyDate(@PathVariable(FeignClientApiPathConstants.ARTICLE_ID_REQUEST_PARAM) Long articleId);
}

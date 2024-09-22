package com.emazon.cartservice.adapter.driven.feign.adapter;

import com.emazon.cartservice.adapter.driven.feign.client.ISupplyFeignClient;
import com.emazon.cartservice.domain.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyAdapter implements ISupplyPersistencePort {
    private final ISupplyFeignClient supplyFeignClient;

    @Override
    public String getNextSupplyDate(Long articleId) {
        return supplyFeignClient.getNextSupplyDate(articleId).getNextSupplyDate();
    }
}

package com.emazon.cartservice.configuration;

import com.emazon.cartservice.adapter.driven.feign.adapter.StockAdapter;
import com.emazon.cartservice.adapter.driven.feign.adapter.SupplyAdapter;
import com.emazon.cartservice.adapter.driven.feign.client.IStockFeignClient;
import com.emazon.cartservice.adapter.driven.feign.client.ISupplyFeignClient;
import com.emazon.cartservice.adapter.driven.jpa.adapter.AuthenticationAdapter;
import com.emazon.cartservice.adapter.driven.jpa.adapter.ShoppingCartAdapter;
import com.emazon.cartservice.adapter.driven.jpa.mapper.IShoppingCartEntityMapper;
import com.emazon.cartservice.adapter.driven.jpa.repository.IShoppingCartRepository;
import com.emazon.cartservice.domain.api.IShoppingCartServicePort;
import com.emazon.cartservice.domain.api.usecase.ShoppingCartUseCase;
import com.emazon.cartservice.domain.spi.IAuthenticationPort;
import com.emazon.cartservice.domain.spi.IShoppingCartPersistencePort;
import com.emazon.cartservice.domain.spi.IStockPersistencePort;
import com.emazon.cartservice.domain.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IShoppingCartRepository shoppingCartRepository;
    private final IShoppingCartEntityMapper shoppingCartEntityMapper;
    private final IStockFeignClient stockFeignClient;
    private final ISupplyFeignClient supplyFeignClient;

    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyAdapter(supplyFeignClient);
    }

    @Bean
    public IAuthenticationPort authenticationPort() {
        return new AuthenticationAdapter();
    }

    @Bean
    public IStockPersistencePort stockPersistencePort() {
        return new StockAdapter(stockFeignClient);
    }

    @Bean
    public IShoppingCartPersistencePort shoppingCartPersistencePort() {
        return new ShoppingCartAdapter(shoppingCartRepository, shoppingCartEntityMapper);
    }

    @Bean
    public IShoppingCartServicePort shoppingCartServicePort() {
        return new ShoppingCartUseCase(
                shoppingCartPersistencePort(),
                stockPersistencePort(),
                authenticationPort(),
                supplyPersistencePort()
        );
    }

}

package com.emazon.cartservice.configuration.feign;

import feign.Client;
import feign.RequestInterceptor;
import feign.httpclient.ApacheHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Client feignClient() {
        return new ApacheHttpClient();
    }

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignInterceptor();
    }
}

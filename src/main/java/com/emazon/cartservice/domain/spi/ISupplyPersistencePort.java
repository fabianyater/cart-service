package com.emazon.cartservice.domain.spi;

public interface ISupplyPersistencePort {
    String getNextSupplyDate(Long articleId);
}

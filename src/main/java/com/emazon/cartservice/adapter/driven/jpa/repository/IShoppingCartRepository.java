package com.emazon.cartservice.adapter.driven.jpa.repository;

import com.emazon.cartservice.adapter.driven.jpa.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {
    Optional<ShoppingCartEntity> findByArticleIdAndUserId(Long articleId, Long userId);
    List<ShoppingCartEntity> findByUserId(Long userId);
    LocalDate findCartLastUpdatedDateByUserId(Long cartId);

}

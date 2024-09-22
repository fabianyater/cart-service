package com.emazon.cartservice.domain.model;

import java.time.LocalDate;

public class ShoppingCart {
    private Long id;
    private Integer quantity;
    private LocalDate updatedAt;
    private LocalDate createdAt;
    private Long articleId;
    private Long userId;

    public ShoppingCart() {
    }

    public ShoppingCart(Long id, Integer quantity, LocalDate updatedAt, LocalDate createdAt, Long articleId, Long userId) {
        this.id = id;
        this.quantity = quantity;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.articleId = articleId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

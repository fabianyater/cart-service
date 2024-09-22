package com.emazon.cartservice.adapter.driven.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "shopping_carts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private LocalDate updatedAt;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private Long articleId;

    @Column(nullable = false)
    private Long userId;
}

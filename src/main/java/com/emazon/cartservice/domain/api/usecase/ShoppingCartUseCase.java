package com.emazon.cartservice.domain.api.usecase;

import com.emazon.cartservice.domain.api.IShoppingCartServicePort;
import com.emazon.cartservice.domain.exception.CategoriesLimitExceedException;
import com.emazon.cartservice.domain.exception.InsufficientStockException;
import com.emazon.cartservice.domain.exception.NextSupplyDateException;
import com.emazon.cartservice.domain.exception.NotFoundException;
import com.emazon.cartservice.domain.model.ShoppingCart;
import com.emazon.cartservice.domain.spi.IAuthenticationPort;
import com.emazon.cartservice.domain.spi.IShoppingCartPersistencePort;
import com.emazon.cartservice.domain.spi.IStockPersistencePort;
import com.emazon.cartservice.domain.spi.ISupplyPersistencePort;
import com.emazon.cartservice.domain.util.DomainConstants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartUseCase implements IShoppingCartServicePort {
    private final IShoppingCartPersistencePort shoppingCartPersistencePort;
    private final IStockPersistencePort stockPersistencePort;
    private final IAuthenticationPort authenticationPort;
    private final ISupplyPersistencePort supplyPersistencePort;

    public ShoppingCartUseCase(
            IShoppingCartPersistencePort shoppingCartPersistencePort,
            IStockPersistencePort stockPersistencePort, IAuthenticationPort authenticationPort, ISupplyPersistencePort supplyPersistencePort) {
        this.shoppingCartPersistencePort = shoppingCartPersistencePort;
        this.stockPersistencePort = stockPersistencePort;
        this.authenticationPort = authenticationPort;
        this.supplyPersistencePort = supplyPersistencePort;
    }

    @Override
    public ShoppingCart addItemToShoppingCart(ShoppingCart shoppingCart) {
        Long userId = authenticationPort.getUserId();
        Long articleId = shoppingCart.getArticleId();
        Integer requestedQuantity = shoppingCart.getQuantity();

        shoppingCart.setUserId(userId);

        validateArticleExists(articleId);
        validateStockAvailability(articleId, requestedQuantity);

        ShoppingCart existingShoppingCart = shoppingCartPersistencePort.getArticleByUserIdAndArticleId(articleId, userId);

        if (existingShoppingCart != null) {
            updateExistingCart(existingShoppingCart, shoppingCart.getQuantity());
            return shoppingCartPersistencePort.addItemToShoppingCart(existingShoppingCart);
        } else {
            List<Long> articleIds = new ArrayList<>(shoppingCartPersistencePort.getArticlesByUserId(userId));
            articleIds.add(articleId);

            validateCategoriesLimit(articleIds);
            createNewCart(shoppingCart);
            return shoppingCartPersistencePort.addItemToShoppingCart(shoppingCart);
        }
    }

    @Override
    public String getLastUpdatedDateCartByUserId(Long userId) {
        return shoppingCartPersistencePort.getLastUpdatedDateCartByUserId(userId);
    }

    private void validateArticleExists(Long articleId) {
        if (!stockPersistencePort.existsById(articleId)) {
            throw new NotFoundException(DomainConstants.ARTICLE_NOT_FOUND);
        }
    }

    private void validateStockAvailability(Long articleId, Integer requestedQuantity) {
        if (!stockPersistencePort.isStockAvailable(articleId, requestedQuantity)) {
            String nextSupplyDate = supplyPersistencePort.getNextSupplyDate(articleId);

            if (nextSupplyDate == null) {
                throw new NextSupplyDateException(DomainConstants.INVALID_DATE_FORMAT);
            }

            throw new InsufficientStockException(DomainConstants.INSUFFICIENT_STOCK, nextSupplyDate);
        }
    }

    private void validateCategoriesLimit(List<Long> articleIds) {
        Map<String, Integer> categoryCountMap = new HashMap<>();

        for (Long productId : articleIds) {
            List<String> categories = stockPersistencePort.getCategoryNamesByArticleId(productId);

            for (String category : categories) {
                categoryCountMap.put(category, categoryCountMap
                        .getOrDefault(category, DomainConstants.DEFAULT_MAP_VALUE) + DomainConstants.INCREMENT_VALUE);

                if (categoryCountMap.get(category) > DomainConstants.MAX_ALLOWED_CATEGORIES_VALUE) {
                    throw new CategoriesLimitExceedException(DomainConstants.CATEGORIES_LIMIT_EXCEED + category);
                }
            }
        }
    }

    private void updateExistingCart(ShoppingCart existingCart, Integer additionalQuantity) {
        existingCart.setQuantity(existingCart.getQuantity() + additionalQuantity);
        existingCart.setUpdatedAt(LocalDate.now());
    }

    private void createNewCart(ShoppingCart shoppingCart) {
        shoppingCart.setCreatedAt(LocalDate.now());
        shoppingCart.setUpdatedAt(LocalDate.now());
    }
}

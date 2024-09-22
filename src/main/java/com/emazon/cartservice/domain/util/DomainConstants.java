package com.emazon.cartservice.domain.util;

public class DomainConstants {



    private DomainConstants() {}

    public static final String MIN_ARTICLE_ID_VALUE_REQUIRED = "'articleId' value should be greater than 0";
    public static final String CATEGORIES_LIMIT_EXCEED = "A maximum of 3 articles per category is allowed";
    public static final String MIN_QUANTITY_VALUE_REQUIRED = "'quantity' value should be greater than 0";
    public static final String INSUFFICIENT_STOCK = "Insufficient stock. Next supply date is: ";
    public static final String ARTICLE_ID_REQUIRED = "'articleId' request param is required";
    public static final String QUANTITY_ID_REQUIRED = "'quantity' request param is required";
    public static final String ARTICLE_NOT_FOUND = "Article was not found";
    public static final String INVALID_DATE_FORMAT = "Invalid date format";
    public static final Integer MAX_ALLOWED_CATEGORIES_VALUE = 3;
    public static final long MIN_ARTICLE_ID_VALUE = 1L;
    public static final Integer DEFAULT_MAP_VALUE = 0;
    public static final long MIN_QUANTITY_VALUE = 1L;
    public static final Integer INCREMENT_VALUE = 1;
}

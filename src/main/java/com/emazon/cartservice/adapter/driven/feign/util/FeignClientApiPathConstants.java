package com.emazon.cartservice.adapter.driven.feign.util;

public class FeignClientApiPathConstants {

    private FeignClientApiPathConstants() {
    }

    public static final String ARTICLE_ID_REQUEST_PARAM = "articleId";

    public static final String EXISTS_BY_ID = "/articles/{articleId}";
    public static final String AVAILABLE_STOCK = "/articles/{articleId}/available-stock";
    public static final String QUANTITY_REQUEST_PARAM = "quantity";

    public static final String NEXT_SUPPLY_DATE = "/supplies/{articleId}/next-supply-date";

    public static final String GET_CATEGORIES_NAME = "/categories/names/{articleId}";
}

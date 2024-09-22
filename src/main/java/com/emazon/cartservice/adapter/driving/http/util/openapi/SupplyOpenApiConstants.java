package com.emazon.cartservice.adapter.driving.http.util.openapi;

public class SupplyOpenApiConstants {
    private SupplyOpenApiConstants() {}

    public static final String TAG_SUPPLY = "Supply";
    public static final String TAG_DESCRIPTION_SUPPLY = "Operations related to supply management";

    public static final String OPERATION_SUMMARY_ADD_SUPPLY = "Add new supply to an article";
    public static final String OPERATION_DESCRIPTION_ADD_SUPPLY = "Allows authorized users to add a new supply to a specified article.";

    public static final String RESPONSE_DESCRIPTION_CREATED = "Supply added successfully";
    public static final String RESPONSE_DESCRIPTION_BAD_REQUEST = "Invalid input or article not found";

    public static final String PARAMETER_DESCRIPTION_ARTICLE_ID = "ID of the article to which the supply will be added";
    public static final String ARTICLE_PARAM = "articleId";

}

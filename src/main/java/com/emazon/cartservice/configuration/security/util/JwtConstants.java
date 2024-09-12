package com.emazon.cartservice.configuration.security.util;

public class JwtConstants {
    private JwtConstants() {
    }

    public static final String ROLE_KEY = "role";
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final int TOKEN_PREFIX_LENGTH = 7;
}

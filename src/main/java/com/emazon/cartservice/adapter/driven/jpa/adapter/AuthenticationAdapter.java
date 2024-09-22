package com.emazon.cartservice.adapter.driven.jpa.adapter;

import com.emazon.cartservice.domain.spi.IAuthenticationPort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationAdapter implements IAuthenticationPort {
    @Override
    public Long getUserId() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return Long.valueOf(userDetails.getUsername());
    }
}

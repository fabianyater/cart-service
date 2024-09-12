package com.emazon.cartservice.adapter.driven.jpa.service;

import com.emazon.cartservice.configuration.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomDetailService implements UserDetailsService {
    private final JwtUtils jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        String username = jwtUtils.getUserIdFromToken(token );
        String role = jwtUtils.getRoleFromToken(token);
        Collection<GrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority(role)
        );

        return new User(username, "", authorities);
    }
}

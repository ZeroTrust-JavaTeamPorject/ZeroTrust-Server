package com.example.zerotrust.domain.user.service.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class CustomUser extends User {
    public String displayName;

    public CustomUser(String username, String password, List<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}

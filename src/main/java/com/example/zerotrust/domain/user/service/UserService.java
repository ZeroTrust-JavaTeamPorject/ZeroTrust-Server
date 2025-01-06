package com.example.zerotrust.domain.user.service;

import com.example.zerotrust.domain.authority.domain.repository.AuthorityRepository;
import com.example.zerotrust.domain.user.domain.User;
import com.example.zerotrust.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(String username, String password, String authName) {
        User user = new User(username, passwordEncoder.encode(password), authorityRepository.findByAuthorityName(authName));
        userRepository.save(user);
    }
}

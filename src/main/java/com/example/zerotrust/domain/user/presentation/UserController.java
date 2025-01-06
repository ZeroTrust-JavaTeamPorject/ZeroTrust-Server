package com.example.zerotrust.domain.user.presentation;

import com.example.zerotrust.domain.authority.domain.Authority;
import com.example.zerotrust.domain.authority.domain.repository.AuthorityRepository;
import com.example.zerotrust.domain.user.domain.User;
import com.example.zerotrust.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    // 사용자 목록 조회
    @GetMapping
    public List<User> getUsers(Model model) {
        return userRepository.findAll();
    }

    // 사용자 생성
    @PostMapping
    public String createUser(String userName,
                             String password,
                             String authorityName) {
        Authority authority = authorityRepository.findByAuthorityName(authorityName);

        User user = new User(userName, password, authority);
        userRepository.save(user);
        return "redirect:/account";
    }

    // 사용자 수정 폼
    @GetMapping("/{id}/edit")
    public User getUserById(@PathVariable Long id, Model model) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
    }

    // 사용자 수정
    @PostMapping("/{id}/edit")
    public String updateUser(@PathVariable Long id,
                             String userName,
                             String password,
                             String authorityName) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));

        Authority authority = authorityRepository.findByAuthorityName(authorityName);

        user.update(userName, password, authority);
        userRepository.save(user);
        return "redirect:/account";
    }
}

package com.example.zerotrust.domain.user.presentation;

import com.example.zerotrust.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signup";
    }

    @PostMapping("/signin")
    public void signin(String username, String password, String authName) {
        userService.saveUser(username, password, authName);
    }


}

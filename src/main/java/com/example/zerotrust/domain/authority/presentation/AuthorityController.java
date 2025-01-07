package com.example.zerotrust.domain.authority.presentation;

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
@RequestMapping("/api/authorities")
@RequiredArgsConstructor
public class AuthorityController {

    private final AuthorityRepository authorityRepository;

    @PostMapping
    public String createAuthority(String authorityName) {
        Authority authority = new Authority();
        authority.setAuthorityName(authorityName);
        authorityRepository.save(authority);
        return "redirect:/account";
    }

    @GetMapping("/{id}/edit")
    public Authority getAuthorityById(@PathVariable Long id, Model model) {
        return authorityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Authority not found: " + id));
    }

    @PostMapping("/{id}/edit")
    public String updateAuthority(@PathVariable Long id,
                                  @RequestParam String authorityName) {
        Authority authority = authorityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Authority not found: " + id));

        authority.setAuthorityName(authorityName);
        authorityRepository.save(authority);
        return "redirect:/account";
    }
}

package com.example.zerotrust.domain.authority.presentation;

import com.example.zerotrust.domain.authority.domain.Authority;
import com.example.zerotrust.domain.authority.domain.repository.AuthorityRepository;
import com.example.zerotrust.domain.authority.presentation.dto.res.ResponseAuthority;
import com.example.zerotrust.domain.user.domain.User;
import com.example.zerotrust.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest-api/authorities")
@RequiredArgsConstructor
public class AuthorityRestController {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

//    @GetMapping
//    public List<ResponseAuthority> getAuthorities() {
//        List<Authority> authorities = authorityRepository.findAll();
//        List<ResponseAuthority> responseAuthorities = new ArrayList<>();
//
//        for (Authority authority : authorities) {
//            responseAuthorities.add(new ResponseAuthority(
//                    authority.getAuthorityName()
//            ));
//        }
//        return responseAuthorities;
//    }

    @GetMapping("/{userName}")
    public ResponseAuthority getAuthority(@PathVariable String userName) {
        List<Authority> authorities = authorityRepository.findAll();
        List<String> responseAuthorities = new ArrayList<>();

        for (Authority authority : authorities) {
            responseAuthorities.add(authority.getAuthorityName());
        }

        return new ResponseAuthority(
                userRepository.findByUserName(userName).get().getAuthority().getAuthorityName(),
                responseAuthorities
        );
    }
}

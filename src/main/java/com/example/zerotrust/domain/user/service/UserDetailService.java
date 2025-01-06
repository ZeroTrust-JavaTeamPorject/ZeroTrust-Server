package com.example.zerotrust.domain.user.service;

import com.example.zerotrust.domain.user.domain.repository.UserRepository;
import com.example.zerotrust.domain.user.service.dto.CustomUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        var result = userRepository.findByUserName(userName);
        if (result.isEmpty()){
            throw new UsernameNotFoundException("그런 아이디 없음");
        }
        var user = result.get();

        List<GrantedAuthority> authorityList = new ArrayList<>();
        log.warn("권한: "+result.get().getAuthority().getAuthorityName());
        authorityList.add(new SimpleGrantedAuthority(result.get().getAuthority().getAuthorityName()));

        CustomUser customUser = new CustomUser(user.getUserName(), user.getPassword(), authorityList);
        customUser.displayName = user.getUserName();
        return new User(user.getUserName(), user.getPassword(), authorityList);
    }
}

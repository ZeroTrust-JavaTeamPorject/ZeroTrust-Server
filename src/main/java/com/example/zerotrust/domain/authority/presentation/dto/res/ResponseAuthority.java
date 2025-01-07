package com.example.zerotrust.domain.authority.presentation.dto.res;

import java.util.List;

public record ResponseAuthority (
        String nowAuthName,
        List<String> authList
){
}

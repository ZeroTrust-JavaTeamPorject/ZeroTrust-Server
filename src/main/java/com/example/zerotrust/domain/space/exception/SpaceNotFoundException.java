package com.example.zerotrust.domain.space.exception;

import com.example.zerotrust.global.exception.ZeroTrustException;
import org.springframework.http.HttpStatus;

public class SpaceNotFoundException extends ZeroTrustException {
    public SpaceNotFoundException() {
        super(HttpStatus.NOT_FOUND, "SPACE_NOT_FOUND", "공간(폴더)을 찾을 수 없습니다");
    }
}

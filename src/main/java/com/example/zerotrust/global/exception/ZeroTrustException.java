package com.example.zerotrust.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ZeroTrustException extends RuntimeException {
    private final HttpStatus status;
    private final String errorCode;

    public ZeroTrustException(HttpStatus status, String errorCode, String message) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }
}

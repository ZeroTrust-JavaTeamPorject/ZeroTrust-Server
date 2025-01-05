package com.example.zerotrust.domain.data.exception;

import com.example.zerotrust.global.exception.ZeroTrustException;
import org.springframework.http.HttpStatus;

public class DataNotFoundException extends ZeroTrustException {
    public DataNotFoundException() {
        super(HttpStatus.NOT_FOUND, "DATA_NOT_FOUND", "데이터(파일)을 찾을 수 없습니다.");
    }
}

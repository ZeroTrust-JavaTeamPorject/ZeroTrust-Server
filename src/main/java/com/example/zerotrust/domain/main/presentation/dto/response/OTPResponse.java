package com.example.zerotrust.domain.main.presentation.dto.response;

import java.time.LocalDateTime;

public record OTPResponse(
        String username,
        LocalDateTime connectTime
) {
}

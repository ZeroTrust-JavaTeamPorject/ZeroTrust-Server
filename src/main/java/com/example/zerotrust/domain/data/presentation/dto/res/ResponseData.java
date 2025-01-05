package com.example.zerotrust.domain.data.presentation.dto.res;

public record ResponseData(
        String spaceName,
        String dataName,
        String dataLocation,
        String dataType
) {
}

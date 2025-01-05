package com.example.zerotrust.domain.data.presentation.dto.req;

public record RequestData(
        String spaceName,
        String dataName,
        String dataLocation,
        String dataType
) {
}

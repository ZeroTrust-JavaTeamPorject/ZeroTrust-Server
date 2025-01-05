package com.example.zerotrust.domain.space.service.implementation;

import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.space.domain.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceDeleter {
    private final SpaceRepository spaceRepository;

    public void delete(Long id) {
        spaceRepository.deleteById(id);
    }
}

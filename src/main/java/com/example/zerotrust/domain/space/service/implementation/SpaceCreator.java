package com.example.zerotrust.domain.space.service.implementation;

import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.space.domain.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceCreator {

    private final SpaceRepository spaceRepository;

    public void save(Space space){
        spaceRepository.save(space);
    }
}

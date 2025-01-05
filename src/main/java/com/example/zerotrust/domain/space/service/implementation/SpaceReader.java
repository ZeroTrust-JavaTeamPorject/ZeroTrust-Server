package com.example.zerotrust.domain.space.service.implementation;

import com.example.zerotrust.domain.authority.domain.Authority;
import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.space.domain.repository.SpaceRepository;
import com.example.zerotrust.domain.space.exception.SpaceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceReader {

    private final SpaceRepository spaceRepository;

    public Space findById(Long id) {
        return spaceRepository.findById(id)
                .orElseThrow(SpaceNotFoundException::new);
    }

    public List<Space> findAll() {
        return spaceRepository.findAll();
    }

    public Space findByName(String name) {
        return spaceRepository.findBySpaceName(name);
    }

    public List<Space> findByNames(String name) {
        return spaceRepository.findAllBySpaceNames(name);
    }

    public List<Space> findByAuthoritys(Authority authority) {
        return spaceRepository.findAllByAuthoritys(authority);
    }
}

package com.example.zerotrust.domain.space.service;

import com.example.zerotrust.domain.authority.domain.repository.AuthorityRepository;
import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.space.presentation.dto.req.RequestSpace;
import com.example.zerotrust.domain.space.service.implementation.SpaceCreator;
import com.example.zerotrust.domain.space.service.implementation.SpaceDeleter;
import com.example.zerotrust.domain.space.service.implementation.SpaceReader;
import com.example.zerotrust.domain.space.service.implementation.SpaceUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandSpaceService {

    private final AuthorityRepository authorityRepository;
    private final SpaceCreator spaceCreator;
    private final SpaceReader spaceReader;
    private final SpaceUpdater spaceUpdater;
    private final SpaceDeleter spaceDeleter;

    public void create(RequestSpace space) {
        spaceCreator.save(new Space(
                authorityRepository.findByAuthorityName(space.authorityName()),
                space.spaceName()
        ));
    }

    public void update(Long spaceId, RequestSpace space) {
        spaceUpdater.update(
                spaceReader.findById(spaceId),
                new Space(
                        authorityRepository.findByAuthorityName(space.authorityName()),
                        space.spaceName()
                )
        );
    }

    public void delete(Long spaceId) {
        spaceDeleter.delete(spaceId);
    }
}

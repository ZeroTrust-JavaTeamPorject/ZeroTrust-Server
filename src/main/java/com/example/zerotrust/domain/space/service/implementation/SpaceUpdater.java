package com.example.zerotrust.domain.space.service.implementation;

import com.example.zerotrust.domain.space.domain.Space;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceUpdater {

    public void update(Space updatableSpace, Space space) {
        updatableSpace.update(
                space.getAuthority(),
                space.getSpaceName()
        );
    }
}

package com.example.zerotrust.domain.space.domain.repository;

import com.example.zerotrust.domain.authority.domain.Authority;
import com.example.zerotrust.domain.space.domain.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {
    List<Space> findAllBySpaceName(String name);

    List<Space> findAllByAuthority(Authority authority);

    Space findBySpaceName(String spaceName);
}

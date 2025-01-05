package com.example.zerotrust.domain.authority.domain.repository;

import com.example.zerotrust.domain.authority.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByAuthorityName(String name);
}

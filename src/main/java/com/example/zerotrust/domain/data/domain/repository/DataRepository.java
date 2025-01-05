package com.example.zerotrust.domain.data.domain.repository;

import com.example.zerotrust.domain.data.domain.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {}

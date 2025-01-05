package com.example.zerotrust.domain.data.domain.repository;

import com.example.zerotrust.domain.data.domain.Data;
import com.example.zerotrust.domain.space.domain.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
    List<Data> findAllByDataName(String dataName);

    List<Data> findAllByDataLocation(String dataLocation);

    List<Data> findAllByDataType(String dataType);

    List<Data> findAllBySpace(Space space);
}

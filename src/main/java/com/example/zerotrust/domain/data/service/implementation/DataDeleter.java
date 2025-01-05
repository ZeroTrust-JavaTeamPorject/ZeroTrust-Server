package com.example.zerotrust.domain.data.service.implementation;

import com.example.zerotrust.domain.data.domain.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataDeleter {

    private final DataRepository dataRepository;

    public void delete(Long id){
        dataRepository.deleteById(id);
    }
}

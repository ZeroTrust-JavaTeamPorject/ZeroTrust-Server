package com.example.zerotrust.domain.data.service.implementation;


import com.example.zerotrust.domain.data.domain.Data;
import com.example.zerotrust.domain.data.domain.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataCreator {

    private final DataRepository dataRepository;

    public void save(Data data) {
        dataRepository.save(data);
    }
}

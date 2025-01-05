package com.example.zerotrust.domain.data.service.implementation;

import com.example.zerotrust.domain.data.domain.Data;
import com.example.zerotrust.domain.data.domain.repository.DataRepository;
import com.example.zerotrust.domain.data.exception.DataNotFoundException;
import com.example.zerotrust.domain.space.domain.Space;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataReader {

    private final DataRepository dataRepository;

    public Data findById(Long id) {
        return dataRepository.findById(id)
                .orElseThrow(DataNotFoundException::new);
    }

    public List<Data> findAll(){
        return dataRepository.findAll();
    }

    public List<Data> findAllByName(String name){
        return dataRepository.findAllByDataName(name);
    }

    public List<Data> findAllByLocation(String location){
        return dataRepository.findAllByDataLocation(location);
    }

    public List<Data> findAllByType(String type){
        return dataRepository.findAllByDataType(type);
    }

    public List<Data> findAllBySpace(Space space){
        return dataRepository.findAllBySpace(space);
    }
}

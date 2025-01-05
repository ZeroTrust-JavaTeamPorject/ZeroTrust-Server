package com.example.zerotrust.domain.data.service.implementation;

import com.example.zerotrust.domain.data.domain.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataUpdater {

    public void update(Data updatableData, Data data) {
        updatableData.update(
                data.getSpace(),
                data.getDataName(),
                data.getDataLocation(),
                data.getDataType()
        );
    }
}

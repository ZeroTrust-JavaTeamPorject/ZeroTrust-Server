package com.example.zerotrust.domain.data.service;

import com.example.zerotrust.domain.data.domain.Data;
import com.example.zerotrust.domain.data.presentation.dto.req.RequestData;
import com.example.zerotrust.domain.data.service.implementation.DataCreator;
import com.example.zerotrust.domain.data.service.implementation.DataDeleter;
import com.example.zerotrust.domain.data.service.implementation.DataReader;
import com.example.zerotrust.domain.data.service.implementation.DataUpdater;
import com.example.zerotrust.domain.space.service.QuerySpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandDataService {

    private final QuerySpaceService querySpaceService;
    private final DataCreator dataCreator;
    private final DataReader dataReader;
    private final DataUpdater dataUpdater;
    private final DataDeleter dataDeleter;

    public void create(RequestData data) {
        dataCreator.save(new Data(
                querySpaceService.getSpaceBySpaceName(data.spaceName()),
                data.dataName(),
                data.dataLocation(),
                data.dataType()
        ));
    }

    public void update(Long id, RequestData data) {
        dataUpdater.update(
                dataReader.findById(id),
                new Data(
                        querySpaceService.getSpaceBySpaceName(data.spaceName()),
                        data.dataName(),
                        data.dataLocation(),
                        data.dataType()
                )
        );
    }

    public void delete(Long dataId) {
        dataDeleter.delete(dataId);
    }
}

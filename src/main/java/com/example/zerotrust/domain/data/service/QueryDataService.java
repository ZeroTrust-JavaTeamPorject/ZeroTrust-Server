package com.example.zerotrust.domain.data.service;

import com.example.zerotrust.domain.data.domain.Data;
import com.example.zerotrust.domain.data.presentation.dto.res.ResponseData;
import com.example.zerotrust.domain.data.service.implementation.DataReader;
import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.space.presentation.dto.res.ResponseSpace;
import com.example.zerotrust.domain.space.service.QuerySpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryDataService {

    private final QuerySpaceService querySpaceService;
    private final DataReader dataReader;

    public ResponseData getData(Long id){
        Data data = dataReader.findById(id);

        return new ResponseData(
                data.getSpace().getSpaceName(),
                data.getDataName(),
                data.getDataLocation(),
                data.getDataType()
        );
    }

    public List<ResponseData> getDatas(){
        List<Data> datas = dataReader.findAll();
        List<ResponseData> responseDatas = new ArrayList<>();

        for(Data data : datas){
            responseDatas.add(new ResponseData(
                    data.getSpace().getSpaceName(),
                    data.getDataName(),
                    data.getDataLocation(),
                    data.getDataType()
            ));
        }

        return responseDatas;
    }

    public List<ResponseData> findAllByName(String name){
        List<Data> datas = dataReader.findAllByName(name);
        List<ResponseData> responseDatas = new ArrayList<>();

        for(Data data : datas){
            responseDatas.add(new ResponseData(
                    data.getSpace().getSpaceName(),
                    data.getDataName(),
                    data.getDataLocation(),
                    data.getDataType()
            ));
        }

        return responseDatas;
    }

    public List<ResponseData> findAllByLocation(String name){
        List<Data> datas = dataReader.findAllByLocation(name);
        List<ResponseData> responseDatas = new ArrayList<>();

        for(Data data : datas){
            responseDatas.add(new ResponseData(
                    data.getSpace().getSpaceName(),
                    data.getDataName(),
                    data.getDataLocation(),
                    data.getDataType()
            ));
        }

        return responseDatas;
    }

    public List<ResponseData> findAllByType(String name){
        List<Data> datas = dataReader.findAllByType(name);
        List<ResponseData> responseDatas = new ArrayList<>();

        for(Data data : datas){
            responseDatas.add(new ResponseData(
                    data.getSpace().getSpaceName(),
                    data.getDataName(),
                    data.getDataLocation(),
                    data.getDataType()
            ));
        }

        return responseDatas;
    }

    public List<ResponseData> findAllBySpace(String name){
        List<ResponseSpace> spaces = querySpaceService.getSpacesBySpaceName(name);
        List<Data> datas = new ArrayList<>(List.of());
        List<ResponseData> responseDatas = new ArrayList<>();

        for (ResponseSpace space : spaces) {
            datas.addAll(
                    dataReader.findAllBySpace(
                            querySpaceService.getSpaceBySpaceName(space.spaceName())
                    )
            );
        }

        for(Data data : datas){
            responseDatas.add(new ResponseData(
                    data.getSpace().getSpaceName(),
                    data.getDataName(),
                    data.getDataLocation(),
                    data.getDataType()
            ));
        }

        return responseDatas;
    }

}

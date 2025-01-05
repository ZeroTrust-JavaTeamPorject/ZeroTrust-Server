package com.example.zerotrust.domain.data.presentation;

import com.example.zerotrust.domain.data.domain.Data;
import com.example.zerotrust.domain.data.domain.repository.DataRepository;
import com.example.zerotrust.domain.data.presentation.dto.req.RequestData;
import com.example.zerotrust.domain.data.presentation.dto.res.ResponseData;
import com.example.zerotrust.domain.data.service.CommandDataService;
import com.example.zerotrust.domain.data.service.QueryDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/data")
public class DataController {

    private final CommandDataService commandDataService;
    private final QueryDataService queryDataService;


    @PostMapping("/create")
    public void create(@RequestBody RequestData requestData) {
        commandDataService.create(requestData);
    }

    @PostMapping("/{dataId}/update")
    public void update(@PathVariable Long dataId, @RequestBody RequestData requestData){
        commandDataService.update(dataId, requestData);
    }

    @PostMapping("/{dataId}/delete")
    public void delete(@PathVariable Long dataId){
        commandDataService.delete(dataId);
    }

    @GetMapping("/{dataId}")
    public ResponseData getData(@PathVariable Long dataId){
        return queryDataService.getData(dataId);
    }

    @GetMapping("/")
    public List<ResponseData> getData(){
        return queryDataService.getDatas();
    }

    @GetMapping("/{dataName}")
    public List<ResponseData> getDataByName(@PathVariable String dataName){
        return queryDataService.findAllByName(dataName);
    }

    @GetMapping("/location/{dataLocation}")
    public List<ResponseData> getDataByLocation(@PathVariable String dataLocation){
        return queryDataService.findAllByLocation(dataLocation);
    }

    @GetMapping("/type/{dataType}")
    public List<ResponseData> getDataByDataType(@PathVariable String dataType){
        return queryDataService.findAllByType(dataType);
    }

    @GetMapping("/space/{spaceName}")
    public List<ResponseData> getDataBySpace(@PathVariable String spaceName){
        return queryDataService.findAllBySpace(spaceName);
    }
}

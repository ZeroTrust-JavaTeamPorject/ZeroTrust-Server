package com.example.zerotrust.domain.data.presentation;

import com.example.zerotrust.domain.data.presentation.dto.req.RequestData;
import com.example.zerotrust.domain.data.presentation.dto.res.ResponseData;
import com.example.zerotrust.domain.data.service.CommandDataService;
import com.example.zerotrust.domain.data.service.QueryDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/data")
public class DataRestController {

    private final CommandDataService commandDataService;
    private final QueryDataService queryDataService;


    @PostMapping("/create")
    public void create(@RequestBody RequestData requestData) {
        commandDataService.create(requestData);
    }

    @PostMapping("/{dataId}/update")
    public void update(@PathVariable Long dataId, String spaceName, String dataName, String dataLocation, String dataType){
        commandDataService.update(dataId, new RequestData(
                spaceName,
                dataName,
                dataLocation,
                dataType
        ));
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

    @GetMapping("/space/{spaceName}")
    public List<ResponseData> getDataBySpace(@PathVariable String spaceName){
        return queryDataService.findAllBySpace(spaceName);
    }
}

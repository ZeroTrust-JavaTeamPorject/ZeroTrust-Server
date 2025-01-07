package com.example.zerotrust.domain.space.presentation;

import com.example.zerotrust.domain.space.presentation.dto.res.ResponseSpace;
import com.example.zerotrust.domain.space.service.CommandSpaceService;
import com.example.zerotrust.domain.space.service.QuerySpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/space")
public class SpaceRestController {

    private final QuerySpaceService querySpaceService;

    @GetMapping("/")
    public List<ResponseSpace> getSpaces() {
        return querySpaceService.getSpaces();
    }

    @GetMapping("/{spaceName}")
    public List<ResponseSpace> getSpaceByName(@PathVariable("spaceName") String spaceName) {
        return querySpaceService.getSpacesBySpaceName(spaceName);
    }

}

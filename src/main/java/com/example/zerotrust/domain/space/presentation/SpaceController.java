package com.example.zerotrust.domain.space.presentation;

import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.space.presentation.dto.req.RequestSpace;
import com.example.zerotrust.domain.space.presentation.dto.res.ResponseSpace;
import com.example.zerotrust.domain.space.service.CommandSpaceService;
import com.example.zerotrust.domain.space.service.QuerySpaceService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/space")
public class SpaceController {

    private final CommandSpaceService commandSpaceService;
    private final QuerySpaceService querySpaceService;

    @GetMapping("/")
    public List<ResponseSpace> getSpaces() {
        return querySpaceService.getSpaces();
    }

    @GetMapping("/{spaceId}")
    public ResponseSpace getSpaceById(@PathVariable("spaceId") Long spaceId) {
        return querySpaceService.getSpace(spaceId);
    }

    @GetMapping("/{spaceName}")
    public List<ResponseSpace> getSpaceByName(@PathVariable("spaceName") String spaceName) {
        return querySpaceService.getSpacesBySpaceName(spaceName);
    }

    @GetMapping("/authority/{authName}")
    public List<ResponseSpace> getSpacesByAuthName(@PathVariable("authName") String authName) {
        return querySpaceService.getSpacesByAuthority(authName);
    }

    @PostMapping("/create")
    public void createSpace(
            @RequestBody RequestSpace requestSpace
    ) {
        commandSpaceService.create(requestSpace);
    }

    @PostMapping("/{spaceId}/update")
    public void updateSpace(
            @PathVariable("spaceId") Long spaceId,
            @RequestBody RequestSpace requestSpace
    ) {
        commandSpaceService.update(spaceId, requestSpace);
    }

    @PostMapping("/{spaceId}/delete")
    public void deleteSpace(
            @PathVariable("spaceId") Long spaceId
    ) {
        commandSpaceService.delete(spaceId);
    }
}

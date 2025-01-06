package com.example.zerotrust.domain.space.presentation;

import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.space.presentation.dto.req.RequestSpace;
import com.example.zerotrust.domain.space.presentation.dto.res.ResponseSpace;
import com.example.zerotrust.domain.space.service.CommandSpaceService;
import com.example.zerotrust.domain.space.service.QuerySpaceService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/space")
public class SpaceController {

    private final CommandSpaceService commandSpaceService;
    private final QuerySpaceService querySpaceService;

    @GetMapping("/")
    public List<ResponseSpace> getSpaces() {
        return querySpaceService.getSpaces();
    }

    @GetMapping("/{spaceName}")
    public List<ResponseSpace> getSpaceByName(@PathVariable("spaceName") String spaceName) {
        return querySpaceService.getSpacesBySpaceName(spaceName);
    }

    @PostMapping("/create")
    public String createSpace(
            String authorityName,
            String spaceName
    ) {
        commandSpaceService.create(new RequestSpace(
                authorityName,
                spaceName
        ));
        return "account";
    }

    @PostMapping("/{spaceId}/update")
    public void updateSpace(
            @PathVariable("spaceId") Long spaceId,
            String authorityName,
            String spaceName
    ) {
        commandSpaceService.update(spaceId, new RequestSpace(
                authorityName,
                spaceName
        ));
    }

    @PostMapping("/{spaceId}/delete")
    public void deleteSpace(
            @PathVariable("spaceId") Long spaceId
    ) {
        commandSpaceService.delete(spaceId);
    }
}

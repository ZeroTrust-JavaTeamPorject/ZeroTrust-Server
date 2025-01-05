package com.example.zerotrust.domain.space.service;

import com.example.zerotrust.domain.authority.domain.repository.AuthorityRepository;
import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.space.presentation.dto.res.ResponseSpace;
import com.example.zerotrust.domain.space.service.implementation.SpaceReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuerySpaceService {

    private final SpaceReader spaceReader;
    private final AuthorityRepository authorityRepository;

    public ResponseSpace getSpace(Long spaceId) {
        Space space = spaceReader.findById(spaceId);

        return new ResponseSpace(
                space.getAuthority().getAuthorityName(),
                space.getSpaceName()
        );
    }

    public List<ResponseSpace> getSpaces() {
        List<Space> space = spaceReader.findAll();
        List<ResponseSpace> responseSpaces = new ArrayList<>();

        for (Space s : space) {
            responseSpaces.add(new ResponseSpace(
                    s.getAuthority().getAuthorityName(),
                    s.getSpaceName()
            ));
        }

        return  responseSpaces;
    }

    public Space getSpaceBySpaceName(String spaceName) {
        return spaceReader.findByName(spaceName);
    }

    public List<ResponseSpace> getSpacesBySpaceName(String spaceName) {
        List<Space> space = spaceReader.findByNames(spaceName);
        List<ResponseSpace> responseSpaces = new ArrayList<>();

        for (Space s : space) {
            responseSpaces.add(new ResponseSpace(
                    s.getAuthority().getAuthorityName(),
                    s.getSpaceName()
            ));
        }

        return responseSpaces;
    }

    public List<ResponseSpace> getSpacesByAuthority(String authorityName) {
        List<Space> space = spaceReader.findByAuthoritys(
                authorityRepository.findByAuthorityName(authorityName)
        );;
        List<ResponseSpace> responseSpaces = new ArrayList<>();

        for (Space s : space) {
            responseSpaces.add(new ResponseSpace(
                    s.getAuthority().getAuthorityName(),
                    s.getSpaceName()
            ));
        }

        return responseSpaces;
    }
}

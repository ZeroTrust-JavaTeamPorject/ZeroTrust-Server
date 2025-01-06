package com.example.zerotrust.domain.main.presentation;

import com.example.zerotrust.domain.data.service.QueryDataService;
import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.space.presentation.dto.res.ResponseSpace;
import com.example.zerotrust.domain.space.service.QuerySpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {


    private final QuerySpaceService querySpaceService;
    private final QueryDataService queryDataService;

    @GetMapping("/")
    public String main(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("space", querySpaceService.getSpaces());

        return "index";
    }

    @GetMapping("/account")
    public String account(Model model) {
        return "account";
    }

    @GetMapping("/monitor")
    public String monitor(Model model) {
        return "monitor";
    }
}

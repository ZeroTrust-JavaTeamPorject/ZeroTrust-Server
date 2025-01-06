package com.example.zerotrust.domain.main.presentation;

import com.example.zerotrust.domain.data.service.QueryDataService;
import com.example.zerotrust.domain.main.presentation.dto.response.OTPResponse;
import com.example.zerotrust.domain.otp.domain.OTP;
import com.example.zerotrust.domain.otp.domain.repository.OTPReository;
import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.space.presentation.dto.res.ResponseSpace;
import com.example.zerotrust.domain.space.service.QuerySpaceService;
import com.example.zerotrust.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {


    private final QuerySpaceService querySpaceService;
    private final QueryDataService queryDataService;
    private final OTPReository otpReository;
    private final UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String main(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("space", querySpaceService.getSpaces());

        return "index";
    }

    @GetMapping("/account")
    public String account(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if(userDetails.getUsername().equals("superadmin")){
            model.addAttribute("users", userRepository.findAll());
            return "account";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/monitor")
    public String monitor(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if(userDetails.getUsername().equals("superadmin")){
            List<OTPResponse> responseOTPs = Arrays.asList();
            List<OTP> otps = otpReository.findAll();

            for(OTP otp : otps){
                responseOTPs.add(new OTPResponse(
                        otp.getUser().getUserName(),
                        otp.getStartTime()
                ));
            }

            model.addAttribute("logs", responseOTPs);

            return "monitor";
        } else {
            return "redirect:/";
        }
    }
}

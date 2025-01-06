package com.example.zerotrust.domain.otp.presentation;

import com.example.zerotrust.domain.otp.service.GoogleOTP;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OtpController {
  String secretKey = GoogleOTP.generateSecretKey();

  @GetMapping("/otp")
  public String otp(Model model) throws Exception {
    String secretKey = GoogleOTP.generateSecretKey();
    model.addAttribute("key", secretKey);
    model.addAttribute("qr", GoogleOTP.getQrCodeUrl("yjh5369", secretKey));
    return "otp";
  }

  @PostMapping("/otp-check")
  public String check(Model model, String otp) {
    model.addAttribute("result", GoogleOTP.checkOtp(secretKey, otp));
    return "otp-check";
  }
}

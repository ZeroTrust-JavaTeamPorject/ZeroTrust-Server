package com.example.zerotrust.domain.otp.presentation;

import com.example.zerotrust.domain.otp.domain.repository.OTPReository;
import com.example.zerotrust.domain.otp.service.GoogleOTP;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OtpController {
  String secretKey = GoogleOTP.generateSecretKey();

  private final OTPReository otpRepository;

  @GetMapping("/otp")
  public String otp(Model model) throws Exception {
    String secretKey = GoogleOTP.generateSecretKey();
    model.addAttribute("key", secretKey);
    model.addAttribute("qr", GoogleOTP.getQrCodeUrl("zerotrust", secretKey));
    return "page/otp";
  }

  @PostMapping("/otp-check")
  public String check(
          Model model,
          HttpServletResponse response,
          HttpServletRequest request,
          String otp
  ) {
    boolean isSuccess = GoogleOTP.checkOtp(secretKey, otp);
    LocalDateTime localDateTime = LocalDateTime.now();
    localDateTime.plusMinutes(30);
//    otpRepository.save(new OTP(
//            ,
//            localDateTime
//    ));
    if (!isSuccess) {
      Cookie cookie = new Cookie("JSESSIONID", null);
      cookie.setPath("/"); // 쿠키 경로를 '/'로 설정
      cookie.setMaxAge(0); // 쿠키 만료 시간 설정 (0으로 설정하면 즉시 만료됨)
      response.addCookie(cookie);

      // 클라이언트에서 세션을 무효화
      request.getSession().invalidate();
    }
    model.addAttribute("result", isSuccess);

    return "page/otp-check";
  }
}

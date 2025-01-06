package com.example.zerotrust.domain.otp.presentation;

import com.example.zerotrust.domain.otp.domain.OTP;
import com.example.zerotrust.domain.otp.domain.repository.OTPReository;
import com.example.zerotrust.domain.otp.service.CustomOTP;
import com.example.zerotrust.domain.otp.service.GoogleOTP;
import com.example.zerotrust.domain.user.domain.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OtpController {

  private final OTPReository otpRepository;
  private final UserRepository userRepository;

//  String secretKey = CustomOTP.generateSecretKey();
//  @GetMapping("/otp")
//  public String otp(Model model) throws Exception {
//    String secretKey = CustomOTP.generateSecretKey();
//    model.addAttribute("key", secretKey);
//    model.addAttribute("qr", CustomOTP.getQrCodeUrl("zerotrust", secretKey));
//    return "otp";
//  }
//
//  @PostMapping("/otp-check")
//  public String check(
//          HttpServletResponse response,
//          HttpServletRequest request,
//          @AuthenticationPrincipal UserDetails userDetails,
//          String otp
//  ) {
//    log.info("Check otp: "+ CustomOTP.getOtpCode(secretKey));
//    log.info("Check otp: "+ otp);
//    boolean isSuccess = CustomOTP.checkOtp(secretKey, otp);
//    if (!isSuccess) {
//      Cookie cookie = new Cookie("JSESSIONID", null);
//      cookie.setPath("/"); // 쿠키 경로를 '/'로 설정
//      cookie.setMaxAge(0); // 쿠키 만료 시간 설정 (0으로 설정하면 즉시 만료됨)
//      response.addCookie(cookie);
//
//      // 클라이언트에서 세션을 무효화
//      request.getSession().invalidate();
//    } else {
//      LocalDateTime localDateTime = LocalDateTime.now();
//      localDateTime.plusMinutes(30);
//      otpRepository.save(new OTP(
//              userRepository.findByUserName(userDetails.getUsername()).get(),
//              localDateTime
//      ));
//
//      return "redirect:/";
//    }
//    return "redirect:/login";
//  }

  private final GoogleOTP googleOTP;

  @GetMapping("/otp")
  public String otp(@AuthenticationPrincipal UserDetails userDetails, Model model) throws Exception {
    String secretKey = googleOTP.generateKey();
    model.addAttribute("key", secretKey);
    model.addAttribute("qr", googleOTP.generateQRUrl(secretKey, userDetails.getUsername()));
    return "otp";
  }

  @PostMapping("/otp-check")
  public String check(
          HttpServletResponse response,
          HttpServletRequest request,
          @AuthenticationPrincipal UserDetails userDetails,
          String secretKey,
          Integer otp
  ) {
    boolean isSuccess = googleOTP.isValid(secretKey, otp);
    if (!isSuccess) {
      Cookie cookie = new Cookie("JSESSIONID", null);
      cookie.setPath("/"); // 쿠키 경로를 '/'로 설정
      cookie.setMaxAge(0); // 쿠키 만료 시간 설정 (0으로 설정하면 즉시 만료됨)
      response.addCookie(cookie);

      // 클라이언트에서 세션을 무효화
      request.getSession().invalidate();
    } else {
      LocalDateTime localDateTime = LocalDateTime.now();
      localDateTime.plusMinutes(30);
      otpRepository.save(new OTP(
              userRepository.findByUserName(userDetails.getUsername()).get(),
              localDateTime
      ));

      return "redirect:/";
    }
    return "redirect:/login";
  }
}

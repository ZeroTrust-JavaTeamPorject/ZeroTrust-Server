package com.example.zerotrust.domain.otp.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Scheduled(fixedDelay = 60000 * 10)
    public void runEvery30Minutes() throws Exception {
        String secretKey = CustomOTP.generateSecretKey();
        String qrCode = CustomOTP.getQrCodeUrl("zerotrust", secretKey);


    }

    public void requestAuth() throws Exception {

    }
}

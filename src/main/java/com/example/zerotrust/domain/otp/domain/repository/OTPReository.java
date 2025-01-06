package com.example.zerotrust.domain.otp.domain.repository;

import com.example.zerotrust.domain.otp.domain.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPReository extends JpaRepository<OTP, Long> {}

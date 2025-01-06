package com.example.zerotrust.domain.otp.domain;

import com.example.zerotrust.domain.space.domain.Space;
import com.example.zerotrust.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class OTP {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long otpId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public OTP(User user, LocalDateTime endTime) {
        this.user = user;
        this.startTime = LocalDateTime.now();
        this.endTime = endTime;
    }
}

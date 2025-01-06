package com.example.zerotrust.domain.authority.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorityId;

    private String authorityName;
}

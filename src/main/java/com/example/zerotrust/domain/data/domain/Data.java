package com.example.zerotrust.domain.data.domain;

import com.example.zerotrust.domain.authority.domain.Authority;
import com.example.zerotrust.domain.space.domain.Space;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dataId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="spaceId")
    private Space space;

    private String dataName;

    private String dataLocation;
}

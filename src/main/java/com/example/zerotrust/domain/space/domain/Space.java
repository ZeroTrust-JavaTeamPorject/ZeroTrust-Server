package com.example.zerotrust.domain.space.domain;

import com.example.zerotrust.domain.authority.domain.Authority;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long spaceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="authorityId")
    private Authority authority;

    private String spaceName;

    public Space(Authority authority, String spaceName) {
        this.authority = authority;
        this.spaceName = spaceName;
    }

    public void update(Authority authority, String spaceName) {
        this.authority = authority;
        this.spaceName = spaceName;
    }
}

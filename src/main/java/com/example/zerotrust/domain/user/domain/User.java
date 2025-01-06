package com.example.zerotrust.domain.user.domain;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="authorityId")
    private Authority authority;

    private String userName;

    private String password;

    public User(String userName, String password, Authority authority) {
        this.userName = userName;
        this.password = password;
        this.authority = authority;
    }

    public void update(String userName, String password, Authority authority) {
        this.userName = userName;
        this.password = password;
        this.authority = authority;
    }

}

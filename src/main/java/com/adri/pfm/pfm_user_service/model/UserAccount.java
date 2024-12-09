package com.adri.pfm.pfm_user_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="PUS_USER_ACCOUNT")
@SequenceGenerator(name = "USER_ACCOUNT_PK", sequenceName = "SEQ_USER_ACCOUNT")
public class UserAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "USER_ACCOUNT_PK")
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "PUS_USER_ACCOUNT_ROLES",
            joinColumns = @JoinColumn(name = "USER_ACCOUNT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles;
}

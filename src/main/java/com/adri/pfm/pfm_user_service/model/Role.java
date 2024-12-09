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
@Table(name="PUS_ROLE")
@SequenceGenerator(name = "ROLE_PK", sequenceName = "SEQ_ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "ROLE_PK")
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "PUS_ACCOUNT_ROLE_PERMISSIONS",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID"))
    private Set<Permission> permissions;
}

package com.adri.pfm.pfm_user_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="PUS_PERMISSION")
@SequenceGenerator(name = "PERMISSION_PK", sequenceName = "SEQ_PERMISSION")
public class Permission {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "PERMISSION_PK")
    private long id;

    @Column(unique = true, nullable = false)
    private String name;
}

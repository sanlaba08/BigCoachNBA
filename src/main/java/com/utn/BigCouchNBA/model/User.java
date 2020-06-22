package com.utn.BigCouchNBA.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dni")
    private String dni;

    @Column(name = "pwd")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role role;



}

package com.bsuir.spp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users",schema = "companyDB")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id",updatable = false,nullable = false)
    private int id;

    @Column(name="user_login",unique = true,nullable = false,length = 50)
    private String login;

    @Column(name="user_passwd",nullable = false,length = 50)
    private String password;

    @Column(name="user_name",nullable = false,length = 50)
    private String name;

    @Column(name="user_mail",nullable = false)
    private String mail;

    @Column(name="user_telephone",nullable = false,length=12)
    private String telephone;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Comment> comments;
}

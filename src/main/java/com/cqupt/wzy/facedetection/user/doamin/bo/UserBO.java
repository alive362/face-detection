package com.cqupt.wzy.facedetection.user.doamin.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
@Setter
@Getter
@ToString
public class UserBO {

    @Id
    @Column(name = "`id`",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`username`")
    private String username;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`email`")
    private String email;

    @Column(name = "`sex`")
    private Integer sex;
}

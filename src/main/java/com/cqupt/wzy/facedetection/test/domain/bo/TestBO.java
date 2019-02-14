package com.cqupt.wzy.facedetection.test.domain.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "test")
@Setter
@Getter
@ToString
public class TestBO {

    @Id
    @Column(name = "`id`",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    @Column(name = "`name`")
    private  String name;

    @Column(name = "`password`")
    private  String password;
}

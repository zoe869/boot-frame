package com.zhong.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name="sys_tbl_privilege")
@Entity
public class Privilege implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "privilege_number")
    private String privilegeNumber;

    @Column(name = "privilege_name")
    private String privilegeName;

    @Column(name = "privilege_tipflag")
    private String privilegeTipflag;

    @Column(name = "privilege_typeflag")
    private String privilegeTypeflag;

    @Column(name = "privilege_url")
    private String privilegeUrl;

    @Column(name = "icon")
    private String icon;


    @JsonIgnore
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})//可选属性optional=false,表示role不能为空
    @JoinColumn(name="role_id")
    private Role role;
}

package com.cssl.pojo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users {
    private Integer uid;// 用户ID
    private  String username;// 用户名
    private  String  password;// 密码
    private  Integer idAdmin;// 权限 管理and用户
}

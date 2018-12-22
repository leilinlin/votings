package com.cssl.dao;

import com.cssl.pojo.Users;

public interface UsersMapper {
    //注册
    public int addUsers(Users users);

    //登录
    public Users selectUser(Users users);

    //用户判断
    public boolean findUsers(String username);
}
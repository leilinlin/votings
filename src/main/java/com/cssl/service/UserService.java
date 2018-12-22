package com.cssl.service;

import com.cssl.pojo.Users;
import org.springframework.stereotype.Repository;
//@Repository注解可以标记在任何的类上，用来表明该类是用来执行与数据库相关的操作（即dao对象），
// 并支持自动处理数据库操作产生的异常
@Repository
public interface UserService  {
   //注册用boolean
   public boolean regisUsers(Users users);
   //登录
   public Users loginUser(Users users);
   //判断用户
   public boolean findUsername(String username);
}

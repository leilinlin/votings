package com.cssl.service.impl;


import com.cssl.dao.UsersMapper;
import com.cssl.pojo.Users;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class UserServiceImpl implements UserService {
    //自动装配持久层
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public boolean regisUsers(Users users) {

       if(usersMapper.addUsers(users)>0){
           return true;
       }
        return false;
    }

    //登录
    @Override
    public Users loginUser(Users users){
        return usersMapper.selectUser(users);
    }


    @Override
    public boolean findUsername(String username){
        if(usersMapper.findUsers(username)){
            return true;
        }
        return false;
    }

}

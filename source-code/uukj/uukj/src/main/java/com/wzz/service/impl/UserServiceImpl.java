package com.wzz.service.impl;

import com.wzz.mapper.UserMapper;
import com.wzz.model.User;
import com.wzz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description TODO  用户业务层实现类
 * @Author AZhen
 * Version 1.0
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int queryUser(Map<String, Object> map) {
        return userMapper.queryUser(map);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void editUser(User user) {
        userMapper.editUser(user);
    }
    @Override
    public int checkuser(String username){
        int i = userMapper.checkuser(username);
        return i;
    }
    @Override
    public User getuser(int id){
        User user=userMapper.getuser(id);
        return user;
    }

    @Override
    public String gettxurl(int id){
        String txurl=userMapper.gettxurl(id);
        return txurl;
    }

    @Override
    public void edittxurl(int id,String txurl){
        userMapper.edittx( id, txurl);
    }
}

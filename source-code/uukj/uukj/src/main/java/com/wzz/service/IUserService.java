package com.wzz.service;

import com.wzz.model.User;
import java.util.Map;

/**
 * @ClassName IUserService
 * @Description TODO 用户业务层接口
 * @Author AZhen
 * Version 1.0
 **/
public interface IUserService {

    int queryUser(Map<String, Object> map);

    void addUser(User user);

    void editUser(User user);

    int checkuser(String username);

    User getuser(int id);

    String gettxurl(int id);

    void edittxurl(int id,String txurl);
}

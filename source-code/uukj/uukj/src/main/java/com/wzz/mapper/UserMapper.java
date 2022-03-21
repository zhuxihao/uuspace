package com.wzz.mapper;

import com.wzz.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserMapper
 * @Description TODO 用户持久层接口
 * @Author AZhen
 * Version 1.0
 **/
public interface UserMapper {

    int queryUser(Map<String,Object> map);

    void addUser(User user);

    void editUser(User user);

    int checkuser(String username);

    User getuser(int id);

    String gettxurl(int id);

    void edittx(@Param("id")int id, @Param("txurl")String txurl);


}

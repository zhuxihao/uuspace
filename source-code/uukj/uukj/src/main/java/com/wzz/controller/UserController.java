package com.wzz.controller;

import com.wzz.common.AssembleResponseMsg;
import com.wzz.model.User;
import com.wzz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wzz.model.ResponseBody;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO 用户控制层
 * @Author AZhen
 * Version 1.0
 **/
@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    //登陆
    @RequestMapping(value = "/queryUser",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public int queryUser(@RequestBody Map<String,Object> map){
        int id = userService.queryUser(map);
        return id;
    }
    //注册
    @RequestMapping(value = "/addUser",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ResponseBody addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(200, "error", "添加用户失败！");
        }
    }
    //修改
    @RequestMapping(value = "/editUser",method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public ResponseBody editUser(@RequestBody User user) {
        try {
            userService.editUser(user);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(200, "error", "修改用户失败！");
        }
    }
    //查重
    @RequestMapping(value = "/checkuser/{username}",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public int countss(@PathVariable("username") String username) {
        int count=userService.checkuser(username);
        return count;
    }
    //查看个人信息
    @RequestMapping(value = "/getuser/{id}",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public User getuser(@PathVariable("id") int id) {
        User user =userService.getuser(id);
        return user;
    }

    //查找头像
    @RequestMapping(value = "/gettxurl/{id}", method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String gettxurl(@PathVariable("id") int id) {
        String txurl =userService.gettxurl(id);
        return txurl;
    }

    //修改头像
    @RequestMapping(value = "/edittx/{id}",method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public ResponseBody edittx(@PathVariable("id") int id , @RequestBody String txurl) {
        try {
            userService.edittxurl(id,txurl);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(200, "error", "修改用户头像失败！");
        }
    }
}

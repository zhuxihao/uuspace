package com.wzz.controller;

import com.wzz.common.AssembleResponseMsg;
import com.wzz.model.ResponseBody;
import com.wzz.model.Rz;
import com.wzz.service.RzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName RzController
 * @Description TODO 日志控制类
 * @Author wzj
 * Version 1.0
 **/
@RestController
public class RzController {
    @Autowired
    private RzService RzService;

    //显示所有日志名字
    @RequestMapping(value = "/queryRznameList/{userid}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public Map queryssList(@PathVariable("userid") int userid){
        Map<String, Object> resultMap =RzService.queryRznameList(userid);
        return resultMap;
    }
    //添加日志
    @RequestMapping(value = "/addRz",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public com.wzz.model.ResponseBody addRz(@RequestBody Rz rz) {
        try {
            RzService.addRz(rz);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(200, "error", "添加日志失败！");
        }
    }
    //删除日志
    @RequestMapping(value = "/delRzbyid/{id}",method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public ResponseBody deleteUserById(@PathVariable("id") int id) {
        try {
            RzService.delRzbyid(id);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(200, "error", "删除日志失败！");
        }
    }
    //统计日志个数
    @RequestMapping(value = "/countRz/{userid}",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public int countss(@PathVariable("userid") int userid) {
        int count=RzService.countRz(userid);
        return count;
    }
    //查询单个日志
    @RequestMapping(value = "/queryRz/{id}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public Rz queryRz(@PathVariable("id") int id){
        Rz rz =RzService.queryRz(id);
        return rz;
    }
}

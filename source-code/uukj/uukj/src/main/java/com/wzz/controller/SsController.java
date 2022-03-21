package com.wzz.controller;


import com.wzz.common.AssembleResponseMsg;
import com.wzz.model.ResponseBody;
import com.wzz.model.ss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wzz.service.ssService;

import java.util.Map;
/**
 * @ClassName SsController
 * @Description TODO 说说控制类
 * @Author wzj
 * Version 1.0
 **/
@RestController
public class SsController {
    @Autowired
    private ssService SsService;
//显示所有说说
    @RequestMapping(value = "/queryssList/{userid}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public Map queryssList(@PathVariable("userid") int userid){
        Map<String, Object> resultMap =SsService.queryssList(userid);
        return resultMap;
    }
//添加说说
    @RequestMapping(value = "/addss", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public ResponseBody addss(@RequestBody ss Ss) {
        try {
            SsService.addss(Ss);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(200, "error", "添加说说失败！");
        }
    }
//删除说说
    @RequestMapping(value = "/delssbyid/{id}",method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public ResponseBody deleteUserById(@PathVariable("id") int id) {
        try {
            SsService.delssbyid(id);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(200, "error", "删除说说失败！");
        }
    }
//统计说说个数
    @RequestMapping(value = "/countss/{userid}", method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public int countss(@PathVariable("userid") int userid) {
            int count=SsService.countss(userid);
            return count;
    }
}

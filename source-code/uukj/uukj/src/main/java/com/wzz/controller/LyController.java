package com.wzz.controller;

import com.wzz.common.AssembleResponseMsg;
import com.wzz.model.Ly;
import com.wzz.model.ResponseBody;
import com.wzz.service.LyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName LyController
 * @Description TODO 留言控制类
 * @Author wzj
 * Version 1.0
 **/
@RestController
public class LyController {
    @Autowired
    private LyService LyService;
    //添加留言
    @RequestMapping(value = "/addLy",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ResponseBody addLy(@RequestBody Ly ly) {
        try {
            LyService.addLy(ly);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(200, "error", "添加留言失败！");
        }
    }
    //删除留言
    @RequestMapping(value = "/delLy/{id}",method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public ResponseBody delLy(@PathVariable("id") int id) {
        try {
            LyService.delLy(id);
            return new AssembleResponseMsg().success("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return new AssembleResponseMsg().failure(200, "error", "删除说说失败！");
        }
    }
    //显示所有留言
    @RequestMapping(value = "/queryLyList/{userid}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public Map queryLyList(@PathVariable("userid") int userid){
        Map<String, Object> resultMap =LyService.queryLyList(userid);
        return resultMap;
    }
    //统计留言个数
    @RequestMapping(value = "/countLy/{userid}",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public int countLy(@PathVariable("userid") int userid) {
        int count=LyService.countLy(userid);
        return count;
    }

}

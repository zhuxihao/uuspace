package com.wzz.controller;

import com.wzz.model.Jy;
import com.wzz.service.JyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName JyController
 * @Description TODO 敬语控制类
 * @Author wzj
 * Version 1.0
 **/
@RestController
public class JyController {
    @Autowired
    private JyService JyService;
    //查询寄语
    @RequestMapping(value = "/queryJy",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public Jy queryJy(){
        Jy Jy =JyService.queryJy();
        return Jy;
    }
}
